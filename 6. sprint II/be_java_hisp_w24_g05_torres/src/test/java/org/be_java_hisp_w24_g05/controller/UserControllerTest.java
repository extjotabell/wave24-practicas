package org.be_java_hisp_w24_g05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.dto.CountFollowersDto;
import org.be_java_hisp_w24_g05.dto.UserFollowedDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void testFollowUserHappyPath() throws Exception {

        String url = "/users/{userId}/follow/{userIdToFollow}";
        String userId = "3";
        String userIdToFollow = "4";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher expectedStatus = status().isOk();

        UserFollowedDto userFollowedDto = new UserFollowedDto(
                3,
                "User3",
                1
        );

        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(userFollowedDto));

        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType);
    }

    @Test
    public void testUnfollowUserHappyPath() throws Exception {

        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        String userId = "1";
        String userIdToUnfollow = "2";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url, userId, userIdToUnfollow);

        ResultMatcher expectedStatus = status().isOk();

        UserFollowedDto userFollowedDto = new UserFollowedDto(
                1,
                "User1",
                2
        );

        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(userFollowedDto));

        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType);
    }

    @Test
    public void testFollowUserAlreadyFollowed() throws Exception {

        String url = "/users/{userId}/follow/{userIdToFollow}";
        String userId = "1";
        String userIdToFollow = "2";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher expectedStatus = status().isBadRequest();

        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType);
    }

    @Test
    public void testFollowUserNotFound() throws Exception {

        String url = "/users/{userId}/follow/{userIdToFollow}";
        String userId = "1";
        String userIdToFollow = "100";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher expectedStatus = status().isBadRequest();

        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType);
    }

    @Test
    public void testSearchUserFollowersHappyPath() throws Exception {

        String url = "/users";

        RequestBuilder request = get(url + "/1/followers/count");

        ResultMatcher statusExpected = status().isOk();

        CountFollowersDto countFollowersDto = new CountFollowersDto(
                1,
                "User1",
                2
        );
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(countFollowersDto));
        ResultMatcher contentExpected = content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentExpected);

    }



}
