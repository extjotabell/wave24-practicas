package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.ErrorDTO;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Register student happy path")
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
    @DisplayName("Register student bad request")
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
    @DisplayName("Get student happy path")
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
    @DisplayName("Get student not found")
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
    @DisplayName("Modify student happy path")
    public void modifyStudentHappyPath() throws Exception {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                2L,
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
    @DisplayName("Modify student bad request")
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

    @Test
    @DisplayName("Remove student happy path")
    public void removeStudent() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.get(url + "/removeStudent/1")
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
    @DisplayName("Remove student not found")
    public void removeStudentNotFound() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.get(url + "/removeStudent/10")
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
    @DisplayName("List students happy path")
    public void listStudents() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = MockMvcRequestBuilders.get(url + "/listStudents")
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body
        List<StudentDTO> expected = List.of(
                new StudentDTO(
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
                ),
                new StudentDTO(
                        2L,
                        "Pedro",
                        List.of(
                                new SubjectDTO(
                                        "Matemática",
                                        10.0
                                ),
                                new SubjectDTO(
                                        "Física",
                                        8.0
                                ),
                                new SubjectDTO(
                                        "Química",
                                        4.0
                                )
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

}
