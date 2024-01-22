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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashSet;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Test integration analyze scores")
    void analyzeScoresTest() throws Exception {

        Long param = 1L;
        StudentWithMessageDTO expectedStudentWithMessageDTO =
                new StudentWithMessageDTO(
                        1L,
                        "Juan",
                        new HashSet<>(List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )),
                        "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                        7.333333333333333D
                );
        MockHttpServletRequestBuilder request = get("/analyzeScores/{studentId}",param);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedStudentWithMessageDTO)
        );

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(print());
    }
}
