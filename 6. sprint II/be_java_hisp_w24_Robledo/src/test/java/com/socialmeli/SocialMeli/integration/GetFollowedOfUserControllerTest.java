package com.socialmeli.SocialMeli.integration;

import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowedDTO;
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
public class GetFollowedOfUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFollowersOfUserAscTestSuccess() throws Exception {
        // Arrange
        String url = "/users/{userId}/followed/list";
        Integer userId = 106;
        String order = "name_asc";

        // Mockear el servicio para que devuelva un UserFollowerDTO simulado
        UserFollowedDTO simulatedUserFollowedDTO = new UserFollowedDTO(userId, "Frank Wilson", List.of(new FollowerDTO(114, "Natalie Turner"), new FollowerDTO(115, "Oliver White")));
        IUserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.getFollowed(userId, order)).thenReturn(simulatedUserFollowedDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("Natalie Turner"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_name").value("Oliver White"));
    }

    @Test
    public void getFollowersOfUserDescTestSuccess() throws Exception {
        // Arrange
        String url = "/users/{userId}/followed/list";
        Integer userId = 106;
        String order = "name_desc";

        // Mockear el servicio para que devuelva un UserFollowerDTO simulado
        UserFollowedDTO simulatedUserFollowedDTO = new UserFollowedDTO(userId, "Frank Wilson", List.of(new FollowerDTO(114, "Natalie Turner"), new FollowerDTO(115, "Oliver White")));
        IUserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.getFollowed(userId, order)).thenReturn(simulatedUserFollowedDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("Oliver White"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_name").value("Natalie Turner"));
    }

    @Test
    public void getFollowerdOfUserTestInvalidUserId() throws Exception {
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
