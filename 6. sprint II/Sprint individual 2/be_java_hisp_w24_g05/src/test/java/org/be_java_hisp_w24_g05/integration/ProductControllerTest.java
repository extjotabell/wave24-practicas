package org.be_java_hisp_w24_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;
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
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private Data data = new Data();

    @Test
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
                //.andExpect(statusExpected) // verifica el status
                //.andExpect(bodyExpected) // verifica el body
                //.andExpect(contentTypeExpected); // verifica el tipo
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    public void testCountUserFollowers() throws Exception {

        String url = "/users";
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
    public void testFollowUserHappyPath() throws Exception {
        String url = "/users/{userId}/follow/{userIdToFollow}";
        String userId = "3";
        String userIdToFollow = "4";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url, userId, userIdToFollow);
        ResultMatcher expectedStatus = status().isOk();
        UserFollowedDto userFollowedDto = new UserFollowedDto(
                3,
                "User3",
                1
        );
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(userFollowedDto));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType);
    }

    @Test
    public void userFollowersTest() throws Exception {
        String url = "/users/{userId}/followers/list";
        String userId = "1";

        UserFollowersDto userFollowersDto = new UserFollowersDto(1, "User1",
                Arrays.asList(new UserDto(2, "User2"), new UserDto(3, "User3")));

        List<UserFollowersDto> expected = Arrays.asList(userFollowersDto);

        RequestBuilder requestBuilder = get(url, userId);
        ResultMatcher expectedStatus = status().isOk();

        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expected));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType);
    }
}

