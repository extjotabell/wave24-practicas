package com.mercadolibre.be_java_hisp_w24_g02.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.ExceptionDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserBasicInfoDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserRelationshipsDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("get users followed test, happy path")
    public void getUsersFollowedTest() throws Exception {
        // Arrange
        String templateUri = "/users/2/followed/list";
        UserBasicInfoDTO userBasicInfoDTO3 = new UserBasicInfoDTO(3, "Usuario 3");
        UserBasicInfoDTO userBasicInfoDTO5 = new UserBasicInfoDTO(5, "Usuario 5");
        UserRelationshipsDTO userExpected = new UserRelationshipsDTO(
                2,
                "Usuario 2",
                new ArrayList<>(List.of(userBasicInfoDTO3, userBasicInfoDTO5)),
                false
        );
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(userExpected)
        );

        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("follow user test, user to follow id is invalid")
    public void followUserTestUserToFollowIdIsInvalid() throws Exception {
        // Arrange
        String templateUri = "/users/1/follow/-100";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ArrayList<>(List.of(new ExceptionDTO("El usuario debe ser igual o mayor a 1"))))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("get users followers test, happy path")
    public void getUsersFollowersTest() throws Exception {
        // Arrange
        String templateUri = "/users/1/followers/list";
        UserBasicInfoDTO userBasicInfoDTO9 = new UserBasicInfoDTO(9, "Usuario 9");
        UserBasicInfoDTO userBasicInfoDTO6 = new UserBasicInfoDTO(6, "Usuario 6");
        UserBasicInfoDTO userBasicInfoDTO5 = new UserBasicInfoDTO(5, "Usuario 5");
        UserBasicInfoDTO userBasicInfoDTO3 = new UserBasicInfoDTO(3, "Usuario 3");
        UserRelationshipsDTO userExpected = new UserRelationshipsDTO(
                1,
                "Usuario 1",
                new ArrayList<>(List.of(userBasicInfoDTO9, userBasicInfoDTO6, userBasicInfoDTO5, userBasicInfoDTO3)),
                true
        );
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(userExpected)
        );

        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("get users followers test, user not found")
    public void getUsersFollowersTestUserNotFound() throws Exception {
        // Arrange
        String templateUri = "/users/90/followers/list";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ExceptionDTO("User not found with id: 90"))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("get users followed test, user not found")
    public void getUsersFollowedTestUserNotFound() throws Exception {
        // Arrange
        String templateUri = "/users/90/followed/list";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ExceptionDTO("User not found with id: 90"))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("get users followers count test, happy path")
    public void getUsersFollowersCountTest() throws Exception {
        // Arrange
        String templateUri = "/users/1/followers/count";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new UserFollowersCountDTO(1, "Usuario 1", 4))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("unfollow user test")
    public void unfollowUserTest() throws Exception {
        // Arrange
        String templateUri = "/users/1/unfollow/2";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8");
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string(
                "Usuario se dejo de seguir exitosamente"
        );
        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("unfollow user test, user id is invalid not found")
    public void unfollowUserTestUserIdIsInvalidNotFound() throws Exception {
        // Arrange
        String templateUri = "/users/90/unfollow/7";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ExceptionDTO("User not found with id: 90"))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("unfollow user test, user unfollow id is invalid not found")
    public void unfollowUserTestUserIdUserUnfollowIsInvalidNotFound() throws Exception {
        // Arrange
        String templateUri = "/users/1/unfollow/80";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ExceptionDTO("User not found with id: 80"))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("unfollow user test, user id is invalid")
    public void unfollowUserTestUserIdUserUnfollowIsInvalid() throws Exception {
        // Arrange
        String templateUri = "/users/1/unfollow/-100";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ArrayList<>(List.of(new ExceptionDTO("El usuario debe ser igual o mayor a 1"))))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }



    @Test
    @DisplayName("follow user test, happy path")
    public void followUserTest() throws Exception {
        // Arrange
        String templateUri = "/users/1/follow/7";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8");
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string(
                "Usuario seguido exitosamente"
        );
        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("follow user test, user id is invalid")
    public void followUserTestUserIdIsInvalid() throws Exception {
        // Arrange
        String templateUri = "/users/-100/follow/7";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        RequestBuilder request = MockMvcRequestBuilders.post(templateUri);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new ArrayList<>(List.of(new ExceptionDTO("El usuario debe ser igual o mayor a 1"))))
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }


}