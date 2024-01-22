package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.ErrorDTO;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final String url = "/student";


    @Test
    public void registerStudentHappyPath() throws Exception {
        // Arrange

        SubjectDTO subjectDTO = new SubjectDTO(
                "Matematica",
                10.0
        );

        StudentDTO studentDTO = new StudentDTO(
                5L,
                "Imanol",
                List.of(subjectDTO));

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.post(url + "/registerStudent")
                .content(
                        mapper.writeValueAsString(studentDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        // paso 3 - construir el expected body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string("");

        // Act

        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);

    }

    @Test
    public void registerStudentBadRequest() throws Exception {
        // Arrange

        SubjectDTO subjectDTO = new SubjectDTO(
                "Matematica",
                10.0
        );

        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Imanol",
                List.of(subjectDTO));

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.post(url + "/registerStudent")
                .content(
                        mapper.writeValueAsString(studentDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // paso 3 - construir el expected body
        ErrorDTO exception = new ErrorDTO("IllegalArgumentException", "El estudiante ya existe");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(exception)
        );

        // Act

        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);

    }

    @Test
    public void getStudentHappyPath() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.get(url + "/getStudent/1")
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body
        StudentDTO expected = new StudentDTO(
                1L,
                "Juan",
                List.of(
                        new SubjectDTO(
                                "Matemática",
                                9.0
                        ),
                        new SubjectDTO(
                                "Física",
                                7.0
                        ),
                        new SubjectDTO(
                                "Química",
                                6.0
                        )
                )
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        // Act

        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);

    }

    @Test
    public void getStudentNotFound() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.get(url + "/getStudent/10")
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // paso 3 - construir el expected body
        ErrorDTO exception = new ErrorDTO("StudentNotFoundException", "El alumno con Id 10 no se encuetra registrado.");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(exception)
        );

        // Act

        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);

    }

    @Test
    public void modifyStudentHappyPath() throws Exception {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Juan",
                List.of(
                        new SubjectDTO(
                                "Matemática",
                                9.0
                        ),
                        new SubjectDTO(
                                "Física",
                                7.0
                        ),
                        new SubjectDTO(
                                "Química",
                                6.0
                        )
                )
        );

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.post(url + "/modifyStudent")
                .content(
                        mapper.writeValueAsString(studentDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        // paso 3 - construir el expected body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string("");

        // Act

        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);
    }

    @Test
    public void modifyStudentBadRequest() throws Exception {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                10L,
                "Juan",
                List.of(
                        new SubjectDTO(
                                "Matemática",
                                9.0
                        ),
                        new SubjectDTO(
                                "Física",
                                7.0
                        ),
                        new SubjectDTO(
                                "Química",
                                6.0
                        )
                )
        );

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.post(url + "/modifyStudent")
                .content(
                        mapper.writeValueAsString(studentDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // paso 3 - construir el expected body
        ErrorDTO exception = new ErrorDTO("StudentNotFoundException", "El alumno con Id 10 no se encuetra registrado.");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(exception)
        );

        // Act

        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);
    }
}
