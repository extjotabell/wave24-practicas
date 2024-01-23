package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

@TestPropertySource(locations = "classpath:application.properties")
public class StudentDAOTest {

    private final StudentDAO studentDAO = new StudentDAO();

    @Test
    public void saveNewStudentTestOk() {
        StudentDTO saved = studentDAO.save(new StudentDTO(8L, "Nicolas", null, null, new ArrayList<>()));
        StudentDTO foundStudent = studentDAO.findById(saved.getId());

        Assertions.assertEquals(saved, foundStudent);
    }

    @Test
    public void findByIdTestOk() {
        StudentDTO foundStudent = studentDAO.findById(1L);

        Assertions.assertEquals(1L, foundStudent.getId());
    }

    @Test
    public void findByIdTestError() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100L));
    }

    @Test
    public void saveExistingStudentOk() {
        StudentDTO saved = studentDAO.save(new StudentDTO(1L, "Nicolas", null, null, new ArrayList<>()));
        StudentDTO foundStudent = studentDAO.findById(saved.getId());

        Assertions.assertEquals(saved, foundStudent);
    }

    @Test
    public void deleteExistingStudentOk() {
        boolean deleted = studentDAO.delete(1L);
        Assertions.assertTrue(deleted);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @Test
    public void deleteNonExistingStudentOk() {
        boolean deleted = studentDAO.delete(100L);
        Assertions.assertFalse(deleted);
    }

    @AfterEach
    public void restoreDatabase() {
        Properties properties =  new Properties();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");

            File backupFile = ResourceUtils.getFile("./src/" + scope + "/resources/users_backup.json");
            Set<StudentDTO> initialData = objectMapper.readValue(backupFile, new TypeReference<Set<StudentDTO>>(){});

            File file = ResourceUtils.getFile("./src/" + scope + "/resources/users.json");
            objectMapper.writeValue(file, initialData);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while restoring DB, check your resources files and JSON formatting.");
        }
    }


}
