package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Verify following a user from the URL, happy path.")
    public void followUserHappyPath() throws Exception {
        //arrange
        // paso 1  request
        int userId = 1;
        int userIdToFollow = 8;
        String url = "/users/{userId}/follow/{userIdToFollow}";
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        // paso 2 - construir el expected del status

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body

        String respuesta = "Usuario seguido exitosamente";

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string(respuesta);

        //paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN + ";charset=UTF-8");

        // act && assert

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);

    }

    @Test
    @DisplayName("Verify following a user from the URL, sad path already following.")
    public void followUserSadPathAlreadyFollowing() throws Exception {
        // Arrange
        int userId = 1;
        int userIdToFollow = 3;

        String url = "/users/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        // Expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // Expected body
        BadRequestException expected = new BadRequestException("Ya estás siguiendo a este usuario: 3");
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message")
                .value("Ya estás siguiendo a este usuario: 3");

        // Expected content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act and assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }


    @Test
    @DisplayName("Verify unfollowing a user from the URL, happy path.")
    public void unfollowUserHappyPath() throws Exception {
        //arrange
        // paso 1 - request
        int userId = 1;
        int userIdToUnfollow = 7;
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToUnfollow);
        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // paso 3 - construir el expected body
        String respuesta = "Usuario se dejo de seguir exitosamente";
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string(respuesta);
        //paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN + ";charset=UTF-8");

        // act && assert

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    @DisplayName("Test correct number of follower count.")
    public void userFollowerCountTest() throws Exception {
        //arrange

        // paso 1 - request

        int userId = 3;

        String url = "/users/{userId}/followers/count";

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        // paso 2 - construir el expected del status

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body

        UserFollowersCountDTO expected = new UserFollowersCountDTO(3, "Usuario 3",4);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        //paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        // act && assert

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }


}
