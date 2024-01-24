package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Set;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.ServerResponse.noContent;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @Test
    public void testRegisterStudent() throws Exception {
        //Arrange

        String url = "/student/registerStudent";

        String json = "{\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"subjects\": [\n" +
                "        {\n" +
                "            \"name\": \"Matematica\",\n" +
                "            \"score\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Lengua\",\n" +
                "            \"score\": 8\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Fisica\",\n" +
                "            \"score\": 9\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusMatcher = status().isNoContent();

        ResultMatcher contentMatcher = content().string("");

        //Act

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(statusMatcher)
                .andExpect(contentMatcher);

        //Assert


    }


}
