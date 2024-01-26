package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void followUserTestHappyPath() throws Exception {
        //arrange
        String param = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1;
        Integer userIdToFollow = 2;
        RequestBuilder request = MockMvcRequestBuilders.post(param, userId, userIdToFollow);
        //act
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }
}
