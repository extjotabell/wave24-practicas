package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.exception.InvalidDuplicatedDataException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentRepository implements IStudentRepository {

    private Set<Student> students;

    public StudentRepository() {
        loadData();
    }
    public StudentRepository(Set<Student> students) {
        this.students = students;
    }

    @Override
    public Set<Student> findAll() {
        return this.students;
    }

    @Override
    public boolean save(Student stu) {
        if (!exists(stu)) stu.setId((this.students.size() + 1L));
        else
            throw new InvalidDuplicatedDataException(stu.getId());

        return students.add(stu);
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;

            Student found = this.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

            students.remove(found);
            ret  = true;

        return ret;
    }

    public boolean exists(Student stu) {
        boolean ret = false;

        ret  = this.findById(stu.getId()).orElse(null) != null;

        return ret;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean update(Student stu) {
        var studentFound = students
                .stream()
                .filter(student -> student.getId().equals(stu.getId()))
                .findFirst()
                .orElse(null);

        if (studentFound == null)
            throw new StudentNotFoundException(stu.getId());

        students = students
                .stream()
                .map(student -> student.getId().equals(stu.getId()) ? stu : student)
                .collect(Collectors.toSet());

        return true;
    }

    private void loadData() {
        Set<Student> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<Student>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.students = loadedData;
    }

}
