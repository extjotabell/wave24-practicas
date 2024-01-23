package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
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

import java.util.HashSet;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {
    MockMvc mockMvc;
    ObjectMapper mapper;

    @Autowired
    public ObtenerDiplomaControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    @DisplayName("Get Diploma Controller: Analyze Scores for Existing Id.")
    void testAnalyzeScores() throws Exception {
        // Arrange
        String url = "/analyzeScores/{studentId}";
        Long param = 1L;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        ResultMatcher status = MockMvcResultMatchers.status().isOk();
        StudentWithMessageDTO expectedResult = new StudentWithMessageDTO(
                1L,
                "Juan",
                new HashSet<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 7.0));
                        add(new SubjectDTO("Química", 6.0));
                    }
                },
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333
        );
        ResultMatcher body = MockMvcResultMatchers
                .content()
                .json(
                         mapper.writeValueAsString(expectedResult)
                );
        ResultMatcher contentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(status, contentType, body);
    }

    @Test
    @DisplayName("Get Diploma Controller: Analyze Scores for Non Existing Id.")
    void testAnalyzeScoresForNonExistingId() throws Exception {
        // Arrange
        String url = "/analyzeScores/{studentId}";
        Long param = 100L;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        ResultMatcher status = MockMvcResultMatchers.status().isNotFound();

        // Act
        // Assert
        mockMvc.perform(request)
               .andDo(MockMvcResultHandlers.print())
               .andExpectAll(status);
    }
}
