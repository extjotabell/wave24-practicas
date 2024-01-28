package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.responseDTO.ExceptionDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import org.junit.jupiter.api.Test;
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
public class GetFollowersCountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO(102, "Bob Smith", 2);

    @Test
    public void getFollowersCountTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/count";
        Integer param = 102;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, param)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userFollowersCountDTO)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    public void getFollowersCountUserNotFoundTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/count";
        Integer param = 201;

        ExceptionDTO expected = new ExceptionDTO(
                "User not found"
        );

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url, param)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}

