package com.socialmeli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.*;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void getListFollowerHappyTest() throws Exception {
        // average
        Integer userId = 3105;

        List<UserDto> orderFolowers = List.of(
                new UserDto(1465, "usuario1"),
                new UserDto(4698, "usuario2"),
                new UserDto(1115, "usuario3")
        );

        UserFollowerDto expected = new UserFollowerDto(3105,
                "usuario6",
                orderFolowers
        );

        String url = "/users/{userId}/followers/list";
        RequestBuilder request = get(url, userId);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getListFollowerNotFoundTest() throws Exception {
        // average
        Integer userId = 8;

        ExceptionDto expected = new ExceptionDto("El usuario "+ userId + " no existe.");

        String url = "/users/{userId}/followers/list";
        RequestBuilder request = get(url, userId);

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getListFollowedHappyTest() throws Exception {
        // average
        Integer userId = 4698;

        List<UserDto> orderFollowed = List.of(
                new UserDto(234, "usuario4"),
                new UserDto(1465, "usuario1"),
                new UserDto(123, "usuario5")
        );

        UserFollowedDto expected = new UserFollowedDto(4698,
                "usuario2",
                orderFollowed
        );

        String url = "/users/{userId}/followed/list";
        RequestBuilder request = get(url, userId);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getListFollowedNotFoundTest() throws Exception {
        // average
        Integer userId = 8;

        ExceptionDto expected = new ExceptionDto("No se encontro un usuario con el id "+ userId);

        String url = "/users/{userId}/followed/list";
        RequestBuilder request = get(url, userId);

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowersNameAscHappyTest() throws Exception {
        // average
        Integer userId = 3105;
        String order = "name_asc";

        List<UserDto> orderFolowers = List.of(
                new UserDto(1465, "usuario1"),
                new UserDto(4698, "usuario2"),
                new UserDto(1115, "usuario3")
        );

        UserFollowerDto expected = new UserFollowerDto(3105,
                "usuario6",
                orderFolowers
        );

        String url = "/users/{userId}/followers/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowersNameDescHappyTest() throws Exception {
        // average
        Integer userId = 3105;
        String order = "name_desc";

        List<UserDto> orderFolowers = List.of(
                new UserDto(1115, "usuario3"),
                new UserDto(4698, "usuario2"),
                new UserDto(1465, "usuario1")
        );

        UserFollowerDto expected = new UserFollowerDto(3105,
                "usuario6",
                orderFolowers
        );

        String url = "/users/{userId}/followers/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowersInvalidOrderTest() throws Exception {
        // average
        Integer userId = 3105;
        String order = "invalid";
        ExceptionDto expected = new ExceptionDto("Orden invalido");

        String url = "/users/{userId}/followers/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowersInvalidUserIdTest() throws Exception {
        // average
        Integer userId = 8;
        String order = "name_asc";
        ExceptionDto expected = new ExceptionDto("El usuario "  + userId +  " no existe.");

        String url = "/users/{userId}/followers/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowedNameAscHappyTest() throws Exception {
        // average
        Integer userId = 4698;
        String order = "name_asc";

        List<UserDto> orderFollowed = List.of(
                new UserDto(1465, "usuario1"),
                new UserDto(234, "usuario4"),
                new UserDto(123, "usuario5")
        );

        UserFollowedDto expected = new UserFollowedDto(4698,
                "usuario2",
                orderFollowed
        );

        String url = "/users/{userId}/followed/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowedNameDescHappyTest() throws Exception {
        // average
        Integer userId = 4698;
        String order = "name_desc";

        List<UserDto> orderFollowed = List.of(
                new UserDto(123, "usuario5"),
                new UserDto(234, "usuario4"),
                new UserDto(1465, "usuario1")
        );

        UserFollowedDto expected = new UserFollowedDto(4698,
                "usuario2",
                orderFollowed
        );

        String url = "/users/{userId}/followed/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getFollowedInvalidOrderTest() throws Exception {
        // average
        Integer userId = 4698;
        String order = "invalid";
        ExceptionDto expected = new ExceptionDto("Orden invalido");

        String url = "/users/{userId}/followed/list?order={order}";
        RequestBuilder request = get(url, userId, order);

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher bodyExpected = content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getTotalFollowersHappyTest() throws Exception{
        // average
        Integer userId = 3105;

        UserFollowersDto expected = new UserFollowersDto(3105,
                "usuario6",
                3
        );

        String url = "/users/{userId}/followers/count";
        RequestBuilder request = get(url, userId);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher bodyExpected = content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }

    @Test
    public void getTotalFollowersInvalidUserIdTest() throws Exception{
        // average
        Integer userId = 8;
        ExceptionDto expected = new ExceptionDto("No se encontro un usuario con el id "  + userId);

        String url = "/users/{userId}/followers/count";
        RequestBuilder request = get(url, userId);

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher bodyExpected = content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verify status code
                .andExpect(bodyExpected) // verify response body
                .andExpect(contentTypeExpected);   // verify content type
    }
}
