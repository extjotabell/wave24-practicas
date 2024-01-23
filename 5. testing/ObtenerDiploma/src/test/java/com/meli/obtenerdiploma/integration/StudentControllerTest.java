package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
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
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    MockMvc mockMvc;
    ObjectMapper mapper;

    @Autowired
    StudentControllerTest(
            MockMvc mockMvc,
            ObjectMapper mapper
    ) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    public void postStudent() throws Exception {
        String url = "/student/registerStudent";
        StudentDTO studentDTO = new StudentDTO(
                4L,
                "Pepe",
                Set.of(new SubjectDTO("Matematica", 9.0),
                        new SubjectDTO("Lengua", 8.0)
                )
        );

        // Request
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(studentDTO));

        // Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }
}
