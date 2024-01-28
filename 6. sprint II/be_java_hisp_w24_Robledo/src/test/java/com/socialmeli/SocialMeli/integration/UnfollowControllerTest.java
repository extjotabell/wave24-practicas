package com.socialmeli.SocialMeli.integration;

import com.socialmeli.SocialMeli.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UnfollowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IUserService userService;

    @Test
    public void unfollowUserSuccess() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer userId = 101;
        Integer userIdToUnfollow = 104;

        // Mock the service to return true
        Mockito.when(userService.unfollow(userId, userIdToUnfollow)).thenReturn(true);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void unfollowUserFailure() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer userId = 103;
        Integer userIdToUnfollow = 104;

        // Mock the service to return false
        Mockito.when(userService.unfollow(userId, userIdToUnfollow)).thenReturn(false);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowUserInvalidUserId() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer invalidUserId = -1;  // Invalid user
        Integer userIdToUnfollow = 2;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, invalidUserId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowUserInvalidUserIdToUnfollow() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer userId = 1;
        Integer invalidUserIdToUnfollow = -1;  // Invalid user

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, userId, invalidUserIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

