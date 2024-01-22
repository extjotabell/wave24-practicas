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
import java.util.*;

@Repository
public class StudentRepository implements IStudentRepository {

    private List<Student> students;

    public StudentRepository() {
        loadData();
    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }

    @Override
    public boolean save(Student stu) {

        if (exists(stu))
            throw new IllegalArgumentException("El estudiante ya existe");

        stu.setId((this.students.size() + 1L));

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

        ret  = this.findById(stu.getId()).isPresent();

        return ret;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst();
    }

    private void loadData() {
        List<Student> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<Student>>(){});
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
