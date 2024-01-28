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
public class GetFollowersOfUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFollowersOfUserAscTestSuccess() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        Integer userId = 106;
        String order = "name_asc";

        // Mockear el servicio para que devuelva un UserFollowerDTO simulado
        UserFollowerDTO simulatedUserFollowerDTO = new UserFollowerDTO(userId, "Frank Wilson", List.of(new FollowerDTO(102, "Bob Smith"), new FollowerDTO(105, "Eva Martinez")));
        IUserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.getUserWithFollowers(userId, order)).thenReturn(simulatedUserFollowerDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Bob Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_name").value("Eva Martinez"));
    }

    @Test
    public void getFollowersOfUserDescTestSuccess() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        Integer userId = 106;
        String order = "name_desc";

        // Mockear el servicio para que devuelva un UserFollowerDTO simulado
        UserFollowerDTO simulatedUserFollowerDTO = new UserFollowerDTO(userId, "Frank Wilson", List.of(new FollowerDTO(102, "Bob Smith"), new FollowerDTO(105, "Eva Martinez")));
        IUserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.getUserWithFollowers(userId, order)).thenReturn(simulatedUserFollowerDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Eva Martinez"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_name").value("Bob Smith"));
    }

    @Test
    public void getFollowersOfUserTestInvalidUserId() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        Integer invalidUserId = -1;  // Usuario no válido

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, invalidUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

