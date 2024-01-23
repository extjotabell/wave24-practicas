package com.demospring.demo.integration.controller;

import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.MateriaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class AlumnoControllerTest {

    private static AlumnoDTO alumnoJoyDto = new AlumnoDTO("1111111",
            "Joy",
            LocalDate.of(2006, 07, 12),
            18,
            List.of(new MateriaDTO(
                    "1", "Matematicas", 7D
            ))
    );

    MockMvc mockMvc;

    ObjectMapper mapper;

    @Autowired
    public AlumnoControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.mapper = objectMapper;
    }

    @Test
    public void getAlumnoByDniHappyPath() throws Exception {

        // Paso 1 - crear la request
        String url = "/alumnos/getBy";
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                        .param("dni", "1111111");

        // Paso 2 - status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Paso 3 - content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Paso 4 - body

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
            mapper.writeValueAsString(
                    alumnoJoyDto
            )
        );

        mockMvc.perform(request) // una request
                .andDo(MockMvcResultHandlers.print()) // el metodo print
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); // Los resultMatchers referentes al status, al body y al contentType

    }

}
