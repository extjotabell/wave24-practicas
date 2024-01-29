package org.be_java_hisp_w24_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadOrderException;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    Data data = new Data();
    @Test
    @DisplayName("search user followers with order asc happy path")
    public void searchUserFollowersWithOrderAscHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followers/list";
        Integer userId = 1;
        String userName= "User1";
        String order = "name_asc";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        UserFollowersDto expected = new UserFollowersDto(1, userName, List.of(
                                                                            new UserDto(2, "User2"),
                                                                            new UserDto(3, "User3"),
                                                                            new UserDto(4, "User4")));

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step 5 build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followers with order desc happy path")
    public void searchUserFollowersWithOrderDescHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followers/list";
        Integer userId = 1;
        String userName= "User1";
        String order = "name_desc";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        UserFollowersDto expected = new UserFollowersDto(1, userName, List.of(
                new UserDto(4, "User4"),
                new UserDto(3, "User3"),
                new UserDto(2, "User2")));

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followers sad path")
    public void searchUserFollowersSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followers/list";
        Integer userId = 1;
        String userName= "User1";
        String order = "name_des";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto("Order isn't valid, please use name_asc or name_desc.");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followers validation exception sad path")
    public void searchUserFollowersValidationExceptionSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followers/list";
        Integer userId = 0;
        String userName= "User1";
        String order = "";



        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ErrorDto expected = new ErrorDto("Se encontraron los siguientes errores en las validaciones: ",
                Arrays.asList("UserId tiene que ser mayor a cero"));

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followed with order asc happy path")
    public void searchUserFollowedWithOrderAscHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followed/list";
        Integer userId = 1;
        String userName= "User1";
        String order = "name_asc";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        UserFollowedByDto expected = new UserFollowedByDto(1, userName, Arrays.asList(
                new UserDto(2, "User2"),
                new UserDto(3, "User3")));

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step 5 build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followed with order desc happy path")
    public void searchUserFollowedWithOrderDescHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followed/list";
        Integer userId = 1;
        String userName= "User1";
        String order = "name_desc";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        UserFollowedByDto expected = new UserFollowedByDto(1, userName, List.of(
                new UserDto(3, "User3"),
                new UserDto(2, "User2")));

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followed sad path")
    public void searchUserFollowedSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/followed/list";
        Integer userId = 1;
        String userName= "User1";
        String order = "name_des";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId)
                .param("order", order);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto(order + " parameter is not valid");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("follow user happy path")
    public void followUserHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 2;
        Integer userIdToFollow = 3;
        String userName= "User2";
        Integer quantityOfFollowers = 1;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId,userIdToFollow);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        UserFollowedDto expected = new UserFollowedDto(userId, userName, quantityOfFollowers);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step 5 build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    @DisplayName("follow user sad path")
    public void followUserSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1;
        Integer userIdToFollow = 2;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId,userIdToFollow);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto("User with id " + userIdToFollow + " already followed");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("follow user follow himself sad path")
    public void followUserFollowHimselfSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer userId = 1;
        Integer userIdToFollow = 1;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId,userIdToFollow);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto("User with id " + userId + " cannot follow himself");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("unfollow user happy path")
    public void unfollowUserHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/unfollow/{userIdTounFollow}";
        Integer userId = 1;
        Integer userIdToUnfollow = 2;
        String userName= "User1";
        Integer quantityOfFollowers = 2;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId,userIdToUnfollow);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        UserFollowedDto expected = new UserFollowedDto(userId, userName,quantityOfFollowers);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step 5 build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("unfollow user sad path")
    public void unfollowUserSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        Integer userId = 2;
        Integer userIdToUnfollow = 3;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId,userIdToUnfollow);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto("User with id " + userIdToUnfollow + " not followed");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("unfollow user unfollow himself sad path")
    public void followUserUnfollowHimselfSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/users/{userId}/unfollow/{userIdToFollow}";
        Integer userId = 1;
        Integer userIdToFollow = 1;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId,userIdToFollow);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto("User with id " + userId + " cannot unfollow himself");

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("search user followers with order asc happy path")
    public void searchUserFollowersCountHappyPath() throws Exception {
        // Arrange
        //just to test user constructor

        // step 1 - request
        String url = "/users/{userId}/followers/count";
        Integer userId = 1;
        String userName= "User1";
        Integer quantityOfFollowers = 3;

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);


        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body
        CountFollowersDto expected = new CountFollowersDto(userId, userName, quantityOfFollowers);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // step 4 - build expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // step 5 build request with given url
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

}
