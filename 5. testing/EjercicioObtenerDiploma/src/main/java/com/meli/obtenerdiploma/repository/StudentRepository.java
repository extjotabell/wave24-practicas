package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentRepository implements IStudentRepository {

    private Set<Student> students;

    public StudentRepository() {
        loadData();
    }

    @Override
    public Set<Student> findAll() {
        System.out.println("students");
        return this.students;
    }

    @Override
    public boolean save(Student stu) {

        if (!exists(stu)) stu.setId((this.students.size() + 1L));
        return students.add(stu);
    }

    @Override
    public boolean delete(Long id) {

        Student found = this.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        students.remove(found);

        return true;
    }

    @Override
    public boolean update(Student stu) {
        var id = this.students.stream().filter(s -> s.getId().equals(stu.getId())).findFirst().orElse(null).getId();

        if(id != -1) {
            this.students.removeIf(s -> s.getId().equals(id));
            this.students.add(stu);
            return true;
        }
        return false;
    }

    public boolean exists(Student stu) {
        boolean ret;

        ret  = this.findById(stu.getId()).orElseThrow(() -> new StudentNotFoundException(stu.getId())) != null;

        return ret;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst();
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
