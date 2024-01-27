package com.socialmeli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.utils.PostUtils;
import com.socialmeli.socialmeli.utils.UserUtils;
import org.junit.jupiter.api.Test;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class SocialControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    PostUtils postUtils = new PostUtils();
    UserUtils userUtils = new UserUtils();

    @Test
    void getAllPostsHappyPath() throws Exception {
        // Arrange
        String url = "/posts";
        List<PostIdDto> expected = new ArrayList<>(
                Arrays.asList(
                        postUtils.getPostIdDto2(),
                        postUtils.getPostIdDto1()
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getAllUsersHappyPath() throws Exception {
        // Arrange
        String url = "/users";
        List<UserDto> expected = new ArrayList<>(
                Arrays.asList(
                        userUtils.getUSER_DTO_4698(),
                        userUtils.getUSER_DTO_1115(),
                        userUtils.getUSER_DTO_1465()
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getTotalFollowersHappyPath() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/count";
        int userId = 4698;
        UserFollowersDto expected = new UserFollowersDto(
                4698,
                "usuario2",
                3
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getTotalFollowersSadPathUserNotFound() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/count";
        int userId = 1110;
        ExceptionDto expected = new ExceptionDto("No se encontro un usuario con el id " + userId);

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getFollowersHappyPath() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        int userId = 1115;
        UserFollowerDto expected = new UserFollowerDto(
                1115,
                "usuario3",
                new ArrayList<>()
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getFollowersSadPathUserNotFound() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        int userId = 1010;
        ExceptionDto expected = new ExceptionDto("El usuario " + userId + " no existe.");

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getFollowersSadPathValidateZeroUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        int userId = 0;
        ErrorDto expected = new ErrorDto(
                "Se encontraron los siguientes errores en las validaciones: ",
                new ArrayList<>(
                        List.of(
                                "El id debe ser mayor a 0"
                        )
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getAllFollowedHappyPath() throws Exception {
        // Arrange
        String url = "/users/{userId}/followed/list";
        int userId = 1465;
        UserFollowedDto expected = new UserFollowedDto(
                1465,
                "usuario1",
                new ArrayList<>(
                        List.of(
                                new UserDto(
                                        4698,
                                        "usuario2"
                                )
                        )
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getAllFollowedSadPathUserNotFound() throws Exception {
        // Arrange
        String url = "/users/{userId}/followed/list";
        int userId = 1010;
        ExceptionDto expected = new ExceptionDto("No se encontro un usuario con el id " + userId);

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void getAllFollowedSadPathZeroUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/followed/list";
        int userId = 0;
        ErrorDto expected = new ErrorDto(
                "Se encontraron los siguientes errores en las validaciones: ",
                new ArrayList<>(
                        List.of(
                                "El id debe ser mayor a 0"
                        )
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.get(url,userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void followHappyPath() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int userId = 1115;
        int userIdToFollow = 1465;
        ResponseDto expected = new ResponseDto("Follow exitoso");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void followSadPathNonExistentUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int nonExistentUser = 1101;
        int userIdToFollow = 1115;
        ExceptionDto expected = new ExceptionDto("El usuario " + nonExistentUser + " no existe");

        RequestBuilder request = MockMvcRequestBuilders.post(url, nonExistentUser, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void followSadPathNonExistentUserToFollow() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int userId = 1115;
        int nonExistentUser = 1010;
        ExceptionDto expected = new ExceptionDto("El usuario " + nonExistentUser + " no existe");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, nonExistentUser);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void followSadPathFollowToFollowedUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int userId = 1465;
        int userIdToFollow = 4698;
        ExceptionDto expected = new ExceptionDto("El usuario " + userId + " ya sigue al usuario " + userIdToFollow);

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void followSadPathFollowToSameUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int userId = 1115;
        ExceptionDto expected = new ExceptionDto("No puede realizar la acción a el mismo usuario");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void unfollowHappyPath() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        int userID = 1115;
        int userIdToUnfollow = 4698;
        ResponseDto expexted = new ResponseDto("Unfollow exitoso");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userID, userIdToUnfollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expexted)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void unfollowSadPathNonExistentUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        int nonExistentUser = 1101;
        int userIdToFollow = 1115;
        ExceptionDto expected = new ExceptionDto("El usuario " + nonExistentUser + " no existe");

        RequestBuilder request = MockMvcRequestBuilders.post(url, nonExistentUser, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void unfollowSadPathNonExistentUserToFollow() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        int userId = 1115;
        int nonExistentUser = 1010;
        ExceptionDto expected = new ExceptionDto("El usuario " + nonExistentUser + " no existe");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, nonExistentUser);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void unfollowSadPathFollowToFollowedUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        int userId = 1465;
        int userIdToFollow = 1115;
        ExceptionDto expected = new ExceptionDto("El usuario " + userId + " no sigue al usuario " + userIdToFollow);

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void unfollowSadPathFollowToSameUser() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        int userId = 1115;
        ExceptionDto expected = new ExceptionDto("No puede realizar la acción a el mismo usuario");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
}
