package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    public void analyzeScoresTestOkHighAverage() throws Exception {
        String name = "Pedro";
        StudentDTO student = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9(name);
        student.setMessage("El alumno " + name + " ha obtenido un promedio de 9,00. Felicitaciones!");
        student.setAverageScore(9.0);
        student.setId(2L);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(student));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void analyzeScoresTestOkLowAverage() throws Exception {
        String name = "Juan";
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(name);
        student.setMessage("El alumno " + name + " ha obtenido un promedio de 6,00. Puedes mejorar.");
        student.setAverageScore(6.0);
        student.setId(1L);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(student));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void analyzeScoresTestNotFound() throws Exception {
        ErrorDTO error = new ErrorDTO("StudentNotFoundException", "El alumno con Id 999 no se encuetra registrado.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 999L);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

}
