package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IStudentRepository studentRepository;

    private static ObjectMapper writer;

    Subject matematica;
    Subject fisica;
    Subject quimica;

    Student student;


    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper();

    }

    @BeforeEach
    public void beforEach() {
        matematica = new Subject("Matemática", 9.0);
        fisica = new Subject("Fisica", 7.0);
        quimica =    new Subject("Quimica",    6.0);

        student =new Student(1L, "Juan", Set.of(matematica, fisica, quimica) );
    }

    @Test
    public void testGivenValidUserIdGetDiplomaWithAverangeScore() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(7.333333333333333))
                .andExpect(jsonPath("$.subjects.length()").value(3));
        ;


    }

    @Test
    void analizeScore() throws Exception {
        // Arrange

        StudentWithMessageDTO studentWithMessageDTO = new StudentWithMessageDTO(
                1L,
                "Juan",
                Set.of(matematica, fisica, quimica).stream()
                        .map(subject -> new SubjectDTO(subject.getName(), subject.getScore()))
                        .collect(Collectors.toSet())
                ,
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333
        );

        String userJson = writer.writeValueAsString(studentWithMessageDTO);
        System.out.println(userJson);


        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/analyzeScores/{studentId}",
                1);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedContentType)
                .andExpect(expectedJson)
                .andExpect(expectedStatus);
    }

    @Test
    void testGivenAnInvalidStudentIdThrowExceptionMessage() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
