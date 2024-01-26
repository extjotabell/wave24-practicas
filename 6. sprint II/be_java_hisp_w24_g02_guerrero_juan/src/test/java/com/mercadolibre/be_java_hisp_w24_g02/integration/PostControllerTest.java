package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreateProductDTO;
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

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void postAPostTestHappyPath() throws Exception {
        //arrange
        String param = "/products/post";
        CreatePostDTO createPostDTO = new CreatePostDTO(
                1,
                "24-01-2024",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                1,
                1000.0
        );

        RequestBuilder request = MockMvcRequestBuilders.post(param)
                .content(
                        mapper.writeValueAsString(createPostDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);
        //act

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }

    @Test
    public void postAPostTestSadPath() throws Exception {
        //arrange
        String param = "/products/post";
        CreatePostDTO createPostDTO = new CreatePostDTO(
                null,
                "24-01-2024",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                1,
                1000.0
        );

        RequestBuilder request = MockMvcRequestBuilders.post(param)
                .content(
                        mapper.writeValueAsString(createPostDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);
        //act

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        //assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }
}
