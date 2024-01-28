package com.socialmeli.SocialMeli.integration;

import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;
import com.socialmeli.SocialMeli.service.implementations.UserService;
import com.socialmeli.SocialMeli.service.interfaces.IUserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void followUserTestSuccess() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 107;
        Integer userIdToFollow = 109;

        // Mockear el servicio para que devuelva un UserFollowerDTO simulado
        UserFollowerDTO simulatedUserFollowerDTO = new UserFollowerDTO(userId, "Grace Davis", List.of(new FollowerDTO(116, "Peter Martinez"), new FollowerDTO(117, "Quinn Hall")));
        IUserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.follow(userId, userIdToFollow)).thenReturn(simulatedUserFollowerDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Peter Martinez"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_name").value("Quinn Hall"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[2].user_name").value("Ivy Carter"));
    }

    @Test
    public void followUserTestInvalidUserId() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer invalidUserId = -1;  // Usuario no válido
        Integer userIdToFollow = 2;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, invalidUserId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followUserTestInvalidUserIdToFollow() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1;
        Integer invalidUserIdToFollow = -1;  // Usuario no válido

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post(url, userId, invalidUserIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

