package org.be_java_hisp_w24_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final Data data = new Data();

    private final String url = "/users";

    @Test
    @DisplayName("[INDIVIDUAL] Test search user followers happy path")
    public void testSearchUserFollowersHappyPath() throws Exception {

        RequestBuilder request = get(url + "/1/followers/count");

        ResultMatcher statusExpected = status().isOk();

        CountFollowersDto countFollowersDto = new CountFollowersDto(
                1,
                "User1",
                2
        );
        ResultMatcher bodyExpected = content().json(mapper.writeValueAsString(countFollowersDto));
        ResultMatcher contentExpected = content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentExpected);

    }

    @Test
    @DisplayName("[INDIVIDUAL] Test search user followers sad path")
    public void testSearchUserFollowedSadPath() throws Exception {

        RequestBuilder request = get(url + "/100/followers/count");

        ResultMatcher statusExpected = status().isNotFound();

        ExceptionDto exceptionDto = new ExceptionDto(
                "User not found"
        );

        ResultMatcher bodyExpected = content().json(mapper.writeValueAsString(exceptionDto));
        ResultMatcher contentExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentExpected);

    }

    @Test
    @DisplayName("[BONUS] Test search user followed happy path")
    public void recentPostsOfFollowedUsersDateDescPositive() throws Exception {
        // Arrange

        // paso 1 - request
        String url = "/products/followed/{userId}/list";
        Integer param = 1;
        RequestBuilder request = get(url, param);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = status().isOk();

        // paso 3 - construir el expected body

        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));
        PostFollowedDto expectedPostsDTO = new PostFollowedDto(1,expectedPosts);

        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expectedPostsDTO)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    @DisplayName("[BONUS] Test search user followers happy path")
    public void searchUserFollowers() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = get(url + "/1/followers/list");

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = status().isOk();

        // paso 3 - construir el expected body

        List<UserFollowersDto> expectedUsers = List.of(
            new UserFollowersDto(1, "User1", List.of(
                    new UserDto(2, "User2"),
                    new UserDto(3, "User3")
                ))
            );

        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expectedUsers)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    @DisplayName("[BONUS] Test search user followed happy path")
    public void getSellerFollowedByUser() throws Exception {
        // Arrange

        // paso 1 - request
        RequestBuilder request = get(url + "/1/followed/list");

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = status().isOk();

        // paso 3 - construir el expected body

        List<UserFollowedByDto> expectedUsers = List.of(
                new UserFollowedByDto(1, "User1", List.of(
                        new UserDto(2, "User2"),
                        new UserDto(3, "User3")
                ))
        );

        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expectedUsers)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    @DisplayName("[BONUS] Test follow user happy path")
    public void followUser() throws Exception {
    // Arrange

        // paso 1 - request
        RequestBuilder request = post(url + "/3/follow/4");

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = status().isOk();

        // paso 3 - construir el expected body

        UserFollowedDto userFollowedDto = new UserFollowedDto(
                3,
                "User3",
                1
        );

        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(userFollowedDto)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
}
