package org.socialmeli.be_java_hisp_w24_g04.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.service.UserService;
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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    ObjectWriter writer = new  ObjectMapper().writer();

    private static final int ID_USER = 102;

    User user;

    @BeforeEach
    public void setUp(){
        user = userService.findById(ID_USER);
    }

    @Test
    @DisplayName("Testing get followers endpoint")
    public void testGetFollowers() throws Exception {
        Set<UserDTO> expectedFollowers = List.of(
                new UserDTO(101, "User1"),
                new UserDTO(103, "User3"),
                new UserDTO(102, "User2")
        ).stream().collect(Collectors.toSet());
        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(user.getUserId(), user.getUsername(), expectedFollowers);
        SingleResponseDTO dtoExpected = new SingleResponseDTO(200, userFollowersDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", ID_USER);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(dtoExpected));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentTypeExpected, contentExpected);
    }

    @Test
    @DisplayName("Testing get followed endpoint")
    public void testGetFollowed() throws Exception {
        Set<UserDTO> followed = userService.getFollowed(ID_USER);
        UserFollowedDTO userFollowersDTO = new UserFollowedDTO(user.getUserId(), user.getUsername(), followed);
        SingleResponseDTO dtoExpected = new SingleResponseDTO(200, userFollowersDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", ID_USER);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(dtoExpected));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentTypeExpected, contentExpected);
    }

    @Test
    @DisplayName("Testing get followers count endpoint")
    public void testGetFollowersCount() throws Exception {
        Integer followersCount = userService.getFollowersCount(ID_USER);
        UserFollowerCountDTO count = new UserFollowerCountDTO(user.getUserId(), user.getUsername(), followersCount);
        SingleResponseDTO dtoExpected = new SingleResponseDTO(200, count);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", ID_USER);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(dtoExpected));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentTypeExpected, contentExpected);
    }

    @Test
    @DisplayName("Testing unfollow endpoint")
    public void testUnfollow() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", ID_USER, 102);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().string("");

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentExpected);
    }

    @Test
    @DisplayName("Testing unfollow endpoint with invalid user id to unfollow")
    public void testUnfollowWithInvalidUserIdToUnfollow() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", ID_USER, 9999);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ErrorResponseDTO expected = new ErrorResponseDTO(404, "User with id 9999 not found");
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentTypeExpected, contentExpected);
    }

    @Test
    @DisplayName("Testing follow endpoint")
    public void testFollow() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToUnfollow}", ID_USER, 102);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().string("");

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentExpected);
    }

}
