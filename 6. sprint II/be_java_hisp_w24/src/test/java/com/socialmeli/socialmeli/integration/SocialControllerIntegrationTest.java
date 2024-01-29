package com.socialmeli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.entities.User;
import com.socialmeli.socialmeli.mapper.Mapper;
import com.socialmeli.socialmeli.utils.PostUtils;
import com.socialmeli.socialmeli.utils.UserUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
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

import java.time.LocalDate;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class SocialControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();
    Mapper mapper = new Mapper();

    UserUtils userUtils = new UserUtils();
    PostUtils postUtils = new PostUtils();

    @Test
    @DisplayName("Test to get total followers in a happy path")
    public void getTotalFollowerTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/count";
        int userId = 1465;
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        User user = userUtils.getUSER_1465();
        UserFollowersDto expected = new UserFollowersDto(user.getUserId(), user.getUserName(), user.getFollowers().size());
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }


    @Test
    @DirtiesContext
    @DisplayName("Test to create a new post in a happy path")
    public void createPostTest() throws Exception {
        // Arrange
        String url = "/products/post";
        RequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postUtils.getPostDtoId1()));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        PostIdDto expected = postUtils.getPostCreated();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test to create a new post in a sad path")
    public void createPostThrowsBadRequestExceptionTest() throws Exception {
        // Arrange
        PostDto postDto = postUtils.getPostDtoWithNonexistentId();
        String url = "/products/post";
        RequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDto));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ExceptionDto expected = new ExceptionDto("No existe el usuario con id: " + postDto.userId());
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }


    @Test
    @DisplayName("Test to get a list of followers in a happy path")
    public void getFollowersListWithoutOrderTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        int userId = 1411;
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        User user = userUtils.getUSER_1411();
        UserFollowerDto expected = new UserFollowerDto(user.getUserId(), user.getUserName(), mapper.convertToUserDtoList(user.getFollowers()));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    @DisplayName("Test to get a list of followers in a happy path")
    public void getFollowersListInDescOrderTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/followers/list";
        int userId = 1411;
        String order = "name_desc";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId).param("order", order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        User user = userUtils.getUSER_1411Ordered();
        UserFollowerDto expected = new UserFollowerDto(user.getUserId(), user.getUserName(), mapper.convertToUserDtoList(user.getFollowers()));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DirtiesContext
    @DisplayName("Test to follow an user in a happy path")
    public void followTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int userId = 1115;
        int userIdToFollow = 1411;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResponseDto expected = new ResponseDto("Follow exitoso");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test to follow an user in a sad path")
    public void followThrowsBadRequestExceptionTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        int userId = 1115;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ExceptionDto expected = new ExceptionDto("No puede realizar la acción a el mismo usuario");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DirtiesContext
    @DisplayName("Test to unfollow an user in a happy path")
    public void unfollowTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        int userId = 1411;
        int userIdToFollow = 1465;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResponseDto expected = new ResponseDto("Unfollow exitoso");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test to unfollow an user in a sad path")
    public void unfollowThrowsNotFoundExceptionTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        int userIdToFollow = 987;
        int userId = 1411;
        RequestBuilder request = MockMvcRequestBuilders.post(url, userId, userIdToFollow);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        ExceptionDto expected = new ExceptionDto("El usuario " + userIdToFollow + " no existe");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test to get a list of followed in a happy path")
    public void getFollowedListWithoutOrderTest() throws Exception {
        // Arrange
        String url = "/users/{userId}/followed/list";
        int userId = 1411;
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        User user = userUtils.getUSER_1411();
        UserFollowedDto expected = new UserFollowedDto(user.getUserId(), user.getUserName(), mapper.convertToUserDtoList(user.getFollowed()));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test to get the last two weeks followed posts in a happy path")
    public void getLastTwoWeeksFollowedPostsTest() throws Exception {
        // Arrange
        String url = "/products/followed/{userId}/list";
        int userId = 1411;

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        UserFollowedPostsDto expected = new UserFollowedPostsDto(userId, List.of(postUtils.getPostDtoId8()));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test to get last two weeks followed posts in a sad path")
    public void getLastTwoWeeksFollowedPostsThrowsNotFoundExceptionTest() throws Exception {
        // Arrange
        String url = "/products/followed/{userId}/list";
        int userId = 1465;

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        ExceptionDto expected = new ExceptionDto("No se encontraron post recientes de los usuarios que sigue el usuario " + userId);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    @DisplayName("Test to get last two weeks followed posts in a sad path")
    public void getLastTwoWeeksFollowedPostsThrowsBadRequestExceptionTest() throws Exception {
        // Arrange
        String url = "/products/followed/{userId}/list";
        int userId = 1411;
        String order = "invalid order";

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId).param("order", order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ExceptionDto expected = new ExceptionDto("Debe ingresar un orden valido");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
}