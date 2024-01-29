package org.be_java_hisp_w24_g05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.internal.Arrays;
import org.be_java_hisp_w24_g05.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void FollowUserTestHappyPath() throws Exception {
        String url = "/users/{userId}/follow/{userIdToFollow}";
        String userId = "3";
        String userIdToFollow = "4";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        UserFollowedDto userFollowedDto = new UserFollowedDto(
                3,
                "User3",
                1
        );
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(userFollowedDto));
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType);
    }


    @Test
    public void searchUserFollowersTest() throws Exception {
        String url = "/users/{userId}/followers/count";
        String userId = "1";

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        CountFollowersDto countFollowersDto = new CountFollowersDto(
                1,
                "User1",
                2
        );
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(countFollowersDto));
        ResultMatcher contentExpected = MockMvcResultMatchers.content().contentType(
        MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentExpected);
    }


    @Test
    public void getSellerFollowedByUserTest() throws Exception {
        String url = "/users/{userId}/followed/list";
        String param = "1";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        UserFollowedByDto expected = new UserFollowedByDto(1, "User1",
                List.of(new UserDto(
                        2, "User2"
                ), new UserDto(
                        3, "User3"
                )));


        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(
                MediaType.APPLICATION_JSON);


        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

}
