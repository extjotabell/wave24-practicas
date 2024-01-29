package com.socialmeli.socialmeli.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.PostIdDto;
import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.dto.UserFollowedDto;
import com.socialmeli.socialmeli.dto.UserFollowerDto;
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
    ObjectMapper objectMapper;
    UserUtils userUtils = new UserUtils();
    PostUtils postUtils = new PostUtils();

    //region Desarrollo Individual
    @Test
    @DisplayName("Test getAllFollowed endpoint with valid userId and order ('name_asc').")
    public void getAllFollowedAscHappyPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_asc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        userFollowedList
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("Test getAllFollowed endpoint with valid userId and order ('name_desc').")
    public void getAllFollowedDescHappyPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_desc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        userFollowedList
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test getAllFollowed endpoint with an invalid userId")
    public void getAllFollowedSadPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 469;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_asc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("No se encontro un usuario con el id " + userId);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); //resultMatchers: status, body, contentType
    }

    @Test
    @DisplayName("Test getAllFollowed endpoint with an invalid order")
    public void getAllFollowedOrderSadPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "invalid");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("Orden invalido" );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); //resultMatchers: status, body, contentType
    }
    //endregion

    //region Bonus
    @Test
    @DisplayName("Test getAllUsers endpoint.")
    public void getAllUsersTest() throws Exception{

        List<UserDto> allUsers = userUtils.getAllUsers();

        //request
        String url = "/users";
        RequestBuilder request = MockMvcRequestBuilders.get(url);

        //status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        allUsers
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); //resultMatchers: status, body, contentType

    }

    @Test
    @DisplayName("Test getAllPosts endpoint.")
    public void getAllPostsTest() throws Exception{
        List<PostIdDto> allPosts = postUtils.getPostsListId();
        //request
        String url = "/posts";
        RequestBuilder request = MockMvcRequestBuilders.get(url);

        //status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        allPosts
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test getAllFollower endpoint with valid userId and order ('name_asc').")
    public void getAllFollowerAscHappyPath() throws Exception {

        UserFollowerDto userFollowerList = userUtils.getFollowerList();

        //Request creation
        String url = "/users/{userId}/followers/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_asc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        userFollowerList
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test getAllFollower endpoint with valid userId and order ('name_desc').")
    public void getAllFollowerDescHappyPath() throws Exception {

        UserFollowerDto userFollowerList = userUtils.getFollowerList();

        //Request creation
        String url = "/users/{userId}/followers/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_desc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        userFollowerList
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test getAllFollower endpoint with an invalid userId")
    public void getAllFollowerSadPath() throws Exception {

        UserFollowerDto userFollowerList = userUtils.getFollowerList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 469;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_asc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("No se encontro un usuario con el id " + userId);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test getAllFollower endpoint with an invalid order")
    public void getAllFollowerOrderSadPath() throws Exception {

        UserFollowerDto userFollowerList = userUtils.getFollowerList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "invalid");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("Orden invalido" );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test follow endpoint with valid userId and userIdToFollow.")
    public void followHappyPathTest() throws Exception{
        //request
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1465;
        Integer userIdToFollow = 1115;

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        //status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("Follow exitoso");

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); //resultMatchers: status, body, contentType

    }

    @Test
    @DisplayName("Test follow endpoint with a non existing userId")
    public void followSadPathTest() throws Exception{
        //request
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 146;
        Integer userIdToFollow = 1115;

        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        //status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("El usuario "+userId + " no existe");

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); //resultMatchers: status, body, contentType

    }

    //endregion
}
