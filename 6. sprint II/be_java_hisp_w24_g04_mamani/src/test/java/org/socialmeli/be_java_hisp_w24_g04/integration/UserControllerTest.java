package org.socialmeli.be_java_hisp_w24_g04.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
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
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void getFollowersCountHappyPath() throws Exception {

        String url = "/users/{userId}/followers/count";
        Integer param = 102;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        UserFollowerCountDTO expected = new UserFollowerCountDTO(102, "User2", 3);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new SingleResponseDTO(200, expected))
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);


    }

    @Test
    public void getFollowersTest() throws Exception {
        String url = "/users/{userId}/followers/list";
        Integer param = 102;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userExpected = new UserFollowersDTO(
                102,
                "User2",
                Set.of(new UserDTO(101, "User1"),
                        new UserDTO(103, "User3"),
                        new UserDTO(102, "User2")));
        SingleResponseDTO expected = new SingleResponseDTO(200, userExpected);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);
    }

    @Test
    public void getFollowedTest() throws Exception {
        String url = "/users/{userId}/followed/list";
        Integer param = 102;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        UserFollowedDTO userExpected = new UserFollowedDTO(
                102,
                "User2",
                Set.of(
                        new UserDTO(103, "User3")));
        SingleResponseDTO expected = new SingleResponseDTO(200, userExpected);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected);
    }

    @Test
    public void followTest() throws Exception {
        String path = "/users/{userId}/follow/{userIdToFollow}";
        Integer userIdParam = 102;
        Integer userIdToFollowParam = 103;
        RequestBuilder request = MockMvcRequestBuilders.post(path, userIdParam, userIdToFollowParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected);
    }

    @Test
    public void followWithInvalidParamTest() throws Exception {
        String path = "/users/{userId}/follow/{userIdToFollow}";
        String userIdParam = "invalid";
        String userIdToFollowParam = "invalid";
        RequestBuilder request = MockMvcRequestBuilders.post(path, userIdParam, userIdToFollowParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected);
    }

    @Test
    public void unfollowTest() throws Exception {
        String path = "/users/{userId}/unfollow/{userIdToFollow}";
        Integer userIdParam = 102;
        Integer userIdToFollowParam = 103;
        RequestBuilder request = MockMvcRequestBuilders.post(path, userIdParam, userIdToFollowParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected);
    }

    @Test
    public void unfollowWithInvalidParamTest() throws Exception {
        String path = "/users/{userId}/unfollow/{userIdToFollow}";
        String userIdParam = "invalid";
        String userIdToFollowParam = "invalid";
        RequestBuilder request = MockMvcRequestBuilders.post(path, userIdParam, userIdToFollowParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected);
    }

}
