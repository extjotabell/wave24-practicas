package com.socialmeli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.utils.PostUtils;
import com.socialmeli.socialmeli.utils.UserUtils;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    PostUtils postUtils = new PostUtils();

    UserUtils userUtils = new UserUtils();


    @Test
    @DisplayName("getTotalFollowers: should return UserFollowersDto when get total followers")
    public void getTotalFollowers() throws Exception {
        String url = "/users/{userId}/followers/count";
        Integer userId = 1465;
        UserFollowersDto expected = new UserFollowersDto(userId, "usuario1", 1);

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("getTotalFollowers (NotFoundException): should return NotFoundException when userId does not exist")
    public void getTotalFollowersNotFoundException() throws Exception {
        String url = "/users/{userId}/followers/count";
        Integer userId = 1;
        String messageError = "No se encontro un usuario con el id " + userId;
        ExceptionDto expected = new ExceptionDto(messageError);

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("getFollowers: should return UserFollowerDto when get followers by userId")
    public void getFollowers() throws Exception {
        String url = "/users/{userId}/followers/list";
        Integer userId = 1465;
        UserFollowerDto expected = new UserFollowerDto(userId, "usuario1", List.of(userUtils.getUSERDTO_4698()));

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("getFollowers (BadRequestException): should return BadRequestException when userId does not exist")
    public void getFollowersBadRequestException() throws Exception {
        String url = "/users/{userId}/followers/list";
        Integer userId = 1;
        String messageError = "El usuario "  + userId +  " no existe.";
        ExceptionDto expected = new ExceptionDto(messageError);

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }


    @Test
    @DisplayName("follow: should return ResponseDto when an user follow to another user")
    public void follow() throws Exception {
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1465;
        Integer userIdToFollow = 123;
        ResponseDto expected = new ResponseDto("Follow exitoso");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("follow (BadRequestException): should return BadRequestException when an user already follows that user")
    public void followBadRequestException() throws Exception {
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1465;
        Integer userIdToFollow = 4698;
        String messageError = "El usuario " + userId + " ya sigue al usuario " + userIdToFollow;
        ResponseDto expected = new ResponseDto(messageError);

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }


    @Test
    @DisplayName("unfollow: should return ResponseDto when an user unfollow to another user")
    public void unfollow() throws Exception {
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer userId = 4698;
        Integer userIdToFollow = 123;
        ResponseDto expected = new ResponseDto("Unfollow exitoso");

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("unfollow (BadRequestException): should return BadRequestException when an user does not follow that user")
    public void unfollowBadRequestException() throws Exception {
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer userId = 1465;
        Integer userIdToFollow = 234;
        String errorMessage = "El usuario " + userId + " no sigue al usuario " + userIdToFollow;
        ResponseDto expected = new ResponseDto(errorMessage);

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }


    @Test
    @DisplayName("getAllFollowed: should return UserFollowedDto")
    public void getAllFollowed() throws Exception {
        String url = "/users/{userId}/followed/list";
        Integer userId = 1115;
        UserFollowedDto expected = new UserFollowedDto(userId, "usuario3", List.of(userUtils.getUSERDTO_4698()));

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("createPost: should return PostIdDto")
    public void createPost() throws Exception {
        String url = "/products/post";
        PostDto postDto = postUtils.getNewPostDto();
        PostIdDto expected = postUtils.getNewPostIdDto();

        RequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(postDto));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("createPost (BadRequestException): should return BadRequestException when userId does not exist")
    public void createPostBadRequestException() throws Exception {
        String url = "/products/post";
        PostDto postDto = postUtils.getNewPostDtoUserIdDoesNotExist();
        String errorMessage = "No existe el usuario con id: " + postDto.userId();
        ResponseDto expected = new ResponseDto(errorMessage);

        RequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(postDto));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
}
