package org.be_java_hisp_w24_g05.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.ExceptionDto;
import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PostFollowedDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    MockMvc mockMvc;

    ObjectMapper mapper;
    private Data data = new Data();
    @Autowired
    public ProductControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.mapper = objectMapper;
    }
    @Test
    public void recentPostsOfFollowedUsersDateDescPositive() throws Exception {
        // Arrange

        // paso 1 - request
        String url = "/products/followed/{userId}/list";
        Integer param = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body

        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));
        PostFollowedDto expectedPostsDTO = new PostFollowedDto(1,expectedPosts);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expectedPostsDTO)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

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
    public void addPostHappyPath() throws Exception {
        String url = "/products/post";
        PostDto postDto = new PostDto(1, "26-01-2024", new ProductDto(
                1, "Teclado Gamer", "Gamer", "Racer", "Black", "Special Edition"), 100, 1500.50);

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(
                        mapper.writeValueAsString(postDto)
                )
                .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        PostDto expected = new PostDto(1, "26-01-2024", new ProductDto(
                1, "Teclado Gamer", "Gamer", "Racer", "Black", "Special Edition"), 100, 1500.50);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    public void addPostSadPathUserDoesntExists() throws  Exception {
        String url = "/products/post";
        PostDto postDto = new PostDto(33333, "26-01-2024", new ProductDto(
                1, "Teclado Gamer", "Gamer", "Racer", "Black", "Special Edition"), 100, 1500.50);
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(
                        mapper.writeValueAsString(postDto)
                )
                .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ExceptionDto expected = new ExceptionDto("User does not exist");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
}
