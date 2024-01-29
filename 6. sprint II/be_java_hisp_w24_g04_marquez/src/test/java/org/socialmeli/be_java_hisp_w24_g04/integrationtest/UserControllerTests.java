package org.socialmeli.be_java_hisp_w24_g04.integrationtest;
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
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testFollowUser() throws Exception {
        // Arrange
        int userId = 101;
        int userIdToFollow = 103;

        String url = "/users/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }

    @Test
    public void testFollowUserInvalidUserId() throws Exception {
        // Arrange
        int invalidUserId = 0; // Non-existent user ID
        int userIdToFollow = 103;

        String url = "/users/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(url, invalidUserId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }
    @Test
    public void testUnfollowUser() throws Exception {
        // Arrange
        int userId = 101;
        int userIdToUnfollow = 103;

        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToUnfollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }

    @Test
    public void testGetFollowerCount() throws Exception {
        // Arrange
        int userId = 102;
        String userName = "User2";
        int expectedFollowerCount = 3;

        String url = "/users/{userId}/followers/count";
        UserFollowerCountDTO expectedData = new UserFollowerCountDTO(userId, userName, expectedFollowerCount);
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, expectedData);

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expectedResponse));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    public void testGetFollowers() throws Exception {
        // Arrange
        int userId = 102;
        String userName = "User2";
        Set<UserDTO> followers = Set.of(new UserDTO(101, "User1"), new UserDTO(103, "User3"), new UserDTO(102, "User2"));
        UserFollowersDTO expectedData = new UserFollowersDTO(userId, userName, followers);

        String url = "/users/{userId}/followers/list";
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, expectedData);

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expectedResponse));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    public void testGetFollowed() throws Exception {
        // Arrange
        int userId = 101;
        String userName = "User1";
        Set<UserDTO> followed = Set.of(new UserDTO(102, "User2"), new UserDTO(103, "User3"));
        UserFollowedDTO expectedData = new UserFollowedDTO(userId, userName, followed);

        String url = "/users/{userId}/followed/list";
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, expectedData);

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expectedResponse));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }
}
