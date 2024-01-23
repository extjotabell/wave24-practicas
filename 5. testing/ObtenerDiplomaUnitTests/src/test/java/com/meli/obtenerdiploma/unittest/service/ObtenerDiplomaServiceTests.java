package com.meli.obtenerdiploma.unittest.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void averageScoreWellCalculated() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(6.0, stu.getAverageScore());
    }

    @Test
    public void averageScoreOver9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9,00. Felicitaciones!", stu.getMessage());
    }

    @Test
    public void averageScoreBelow9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6,00. Puedes mejorar.", stu.getMessage());
    }

    @Test
    public void RequestStudentNameMatchesResponseStudentName() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("Marco", stu.getStudentName());
    }

    @Test
    public void RequestStudentSubjectListMatchesResponseSubjectList() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        List<SubjectDTO> initalList = new ArrayList<>();
        stu.getSubjects().stream().forEach((s) -> initalList.add(SerializationUtils.clone(s)));

        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertTrue(CollectionUtils.isEqualCollection(initalList, stu.getSubjects()));
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
