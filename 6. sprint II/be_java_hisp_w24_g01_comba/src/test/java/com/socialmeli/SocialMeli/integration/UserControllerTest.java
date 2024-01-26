package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.responseDTO.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Test get followers count of user")
    void getFollowersCountTest() throws Exception {

        Integer param = 101;

        UserFollowersCountDTO expectedFollowersCountDTO =
                new UserFollowersCountDTO(101, "Alice Johnson", 2);

        MockHttpServletRequestBuilder request = get("/users/{userId}/followers/count",param);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedFollowersCountDTO)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test get followed users of user")
    void getFollowedTest() throws Exception {

        Integer param = 101;

        UserFollowedDTO expectedUserFollowedDTO = new UserFollowedDTO(
                101,
                "Alice Johnson",
                List.of(
                        new FollowerDTO(104, "David Williams"),
                        new FollowerDTO(105, "Eva Martinez")
                ));

        MockHttpServletRequestBuilder request = get("/users/{userId}/followed/list",param);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedUserFollowedDTO)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test tried to unfollow my self and throw exception")
    void unfollowMyselfTest() throws Exception {

        Integer userId = 101;
        Integer userIdToUnfollow = 101;

        ExceptionDTO expectedExceptionDTO = new ExceptionDTO("You can't unfollow yourself");

        MockHttpServletRequestBuilder request = post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userIdToUnfollow);

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedExceptionDTO)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test tried to unfollow an user and throw exception because is not followed")
    void unfollowNotFollowedUserTest() throws Exception {

        Integer userId = 101;
        Integer userIdToUnfollow = 102;

        ExceptionDTO expectedExceptionDTO = new ExceptionDTO("User not followed");

        MockHttpServletRequestBuilder request = post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userIdToUnfollow);

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedExceptionDTO)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test follow user")
    void followUserTest() throws Exception {

        Integer userId = 101;
        Integer userIdToFollow = 106;

        UserFollowerDTO expectedUserFollowerDTO = new UserFollowerDTO(
                101,
                "Alice Johnson",
                List.of(
                        new FollowerDTO(104, "David Williams"),
                        new FollowerDTO(105, "Eva Martinez"),
                        new FollowerDTO(106, "Frank Wilson")
                ));

        MockHttpServletRequestBuilder request = post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedUserFollowerDTO)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test get followers of user")
    void getFollowersOfUserTest() throws Exception {

        Integer userId = 102;

        UserFollowerDTO expectedUserFollowerDTO = new UserFollowerDTO(
                102,
                "Bob Smith",
                List.of(
                        new FollowerDTO(101, "Alice Johnson"),
                        new FollowerDTO(103, "Charlie Brown")
                ));

        MockHttpServletRequestBuilder request = get("/users/{userId}/followers/list",userId);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedUserFollowerDTO)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

}
