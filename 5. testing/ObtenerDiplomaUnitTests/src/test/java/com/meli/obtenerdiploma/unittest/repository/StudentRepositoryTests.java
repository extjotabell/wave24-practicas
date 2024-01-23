package com.meli.obtenerdiploma.unittest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

    @AfterEach
    public void restoreDatabase() {
        Properties properties = new Properties();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");

            File backupFile = ResourceUtils.getFile("./src/" + scope + "/resources/users_backup.json");
            Set<StudentDTO> initialData = objectMapper.readValue(backupFile, new TypeReference<Set<StudentDTO>>() {
            });

            File file = ResourceUtils.getFile("./src/" + scope + "/resources/users.json");
            objectMapper.writeValue(file, initialData);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while restoring DB, check your resources files and JSON formatting.");
        }
    }
}
