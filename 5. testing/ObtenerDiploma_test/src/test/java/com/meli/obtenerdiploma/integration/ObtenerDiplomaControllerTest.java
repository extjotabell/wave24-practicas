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

import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("analyzeScores: should return ResponseEntity<StudentWithMessageDTO>")
    public void analyzeScores() throws Exception {
        String url = "/analyzeScores/{studentId}";
        Long studentId = 2L;
        RequestBuilder request = MockMvcRequestBuilders.get(url, studentId);

        StudentWithMessageDTO expected = new StudentWithMessageDTO(
                2L,
                "Pedro",
                Set.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)),
                "El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

}
