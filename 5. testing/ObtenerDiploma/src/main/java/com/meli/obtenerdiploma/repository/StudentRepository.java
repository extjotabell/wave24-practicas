package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
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
    public StudentRepository() {
    }

    private Set<Student> students;

    public StudentRepository(Set<Student> students) {
        loadData();
    }

    @Override
    public Set<Student> findAll() {
        return this.students;
    }

    @Override
    public boolean save(Student stu) {
        if (isValidStudent(stu) && (stu.getId() == null || !exists(stu))) {
            stu.setId((long) (this.students.size() + 1L));
            return students.add(stu);
        }
        return false;
    }

    private boolean isValidStudent(Student stu) {
        return stu != null &&
                stu.getStudentName() != null && !stu.getStudentName().trim().isEmpty()
                && isValidSubjects(stu.getSubjects());
    }

    private boolean isValidSubjects(Set<Subject> subjects) {
        if (subjects != null && !subjects.isEmpty()) {
            for (Subject subject : subjects) {
                if (!isValidSubject(subject)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isValidSubject(Subject subject) {
        return subject != null
                && subject.getName() != null && !subject.getName().trim().isEmpty()
                && subject.getScore() != null && subject.getScore() >= 0 && subject.getScore() <= 10;
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

        ret  = this.findById(stu.getId()).orElseThrow(() -> new StudentNotFoundException(stu.getId())) != null;

        return ret;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst()
                .map(Optional::of)
                .orElseThrow(() -> new StudentNotFoundException(id));
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
