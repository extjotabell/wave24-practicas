package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.responseDTO.*;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.repository.implementations.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository for database operations

    // Integration test for the getFollowersCount endpoint
    @Test
    @DisplayName("Get followers count service test")
    public void testGetFollowersCount() throws Exception {
        // Arrange
        int userId = 101;
        //Expected response body
        UserFollowersCountDTO expectedResponse = new UserFollowersCountDTO(userId, "Alice Johnson", 2);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedResponse));
        //URL for the request
        String url = "/users/" + userId + "/followers/count";
        RequestBuilder request = MockMvcRequestBuilders.get(url);
        //Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Verify status
                .andExpect(bodyExpected) // Verify response body
                .andExpect(contentTypeExpected); // Verify response type

    }


    // Integration test for the followUser service method
    @Test
    @DisplayName("Follow user service test")
    public void followUserOkTest() throws Exception {
        // Arrange
        Integer userId = 101;
        Integer userIdToFollow = 102;
        // Define the URL for the POST request
        String url = "/users/" + userId + "/follow/" + userIdToFollow;
        //Expected response body
        UserFollowerDTO expectedResponse = new UserFollowerDTO(userId, "Alice Johnson",
                List.of(new FollowerDTO(104, "David Williams"),
                        new FollowerDTO(105, "Eva Martinez"),
                        new FollowerDTO(userIdToFollow, "Bob Smith")
                ));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedResponse));
        //Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Expecting a 200 OK response
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected); // Expecting the response body to match the expected response
    }

    @Test
    @DisplayName("Follow user with non-existing user ID")
    public void followNonExistingUserTest() throws Exception {
        // Arrange
        Integer userId = 101; // Existing user ID
        Integer nonExistentUserId = 999; // Non-existing user ID

        // Define the URL for the POST request
        String url = "/users/" + userId + "/follow/" + nonExistentUserId;

        // Expected Exception DTO
        ExceptionDTO expectedException = new ExceptionDTO(
                "Follower not found"
        );

        // Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Expected body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedException)
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Verify status
                .andExpect(bodyExpected) // Verify response body
                .andExpect(contentTypeExpected); // Verify response content type
    }

    // Integration test for the unfollowUser service method
    @Test
    @DisplayName("Unfollow user service test")
    public void unfollowUserOkTest() throws Exception {
        // Arrange
        Integer userId = 101;
        Integer userIdToUnfollow = 104;
        // Define the URL for the POST request
        String url = "/users/" + userId + "/unfollow/" + userIdToUnfollow;

        //Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        // Act & Assert
        //As the response status is 204 No Content, we don't need to verify the response body or the content type
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected); // Expecting a 204
    }

    @Test
    @DisplayName("Attempt to unfollow a non-existent user")
    public void unfollowNonExistentUserTest() throws Exception {
        // Arrange
        int userId = 101; // Assume this is an existing user ID
        int nonExistentUserId = 999; // Non-existent user ID

        // Define the URL for the POST request
        String url = "/users/" + userId + "/unfollow/" + nonExistentUserId;

        // Expected Exception DTO
        ExceptionDTO expectedException = new ExceptionDTO(
                "User not found"
        );

        // Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Expected body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedException)
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Verify status
                .andExpect(bodyExpected) // Verify response body
                .andExpect(contentTypeExpected); // Verify response content type
    }

    @Test
    @DisplayName("Unfollow a user who is not being followed")
    public void unfollowUserNotFollowedTest() throws Exception {
        // Arrange
        int userId = 101;
        int nonExistentUserId = 102; //Existant but not followed by 101

        // Define the URL for the POST request
        String url = "/users/" + userId + "/unfollow/" + nonExistentUserId;

        // Expected Exception DTO
        ExceptionDTO expectedException = new ExceptionDTO(
                "User not followed"
        );

        // Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Expected body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedException)
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Verify status
                .andExpect(bodyExpected) // Verify response body
                .andExpect(contentTypeExpected); // Verify response content type
    }

    @Test
    @DisplayName("Get Followers List Test")
    public void getFollowersListTest() throws Exception {
        // Arrange
        int userId = 101; // Alice Johnson
        String url = "/users/" + userId + "/followers/list";

        //Expected response body
        UserFollowerDTO expectedResponse = new UserFollowerDTO(userId, "Alice Johnson",
                List.of(new FollowerDTO(102, "Bob Smith"),
                        new FollowerDTO(103, "Charlie Brown")
                ));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedResponse));

        // Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Verify status
                .andExpect(bodyExpected) // Verify response body
                .andExpect(contentTypeExpected); // Verify response content type
    }

    @Test
    @DisplayName("Get Followed List Test")
    public void getFollowedListTest() throws Exception {
        // Arrange
        int userId = 101; // Alice Johnson
        String url = "/users/" + userId + "/followed/list";

        //Expected response body
        UserFollowedDTO expectedResponse = new UserFollowedDTO(userId, "Alice Johnson",
                List.of(new FollowerDTO(104, "David Williams"),
                        new FollowerDTO(105, "Eva Martinez")
                ));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedResponse));

        // Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Verify status
                .andExpect(bodyExpected) // Verify response body
                .andExpect(contentTypeExpected); // Verify response content type
    }


}
