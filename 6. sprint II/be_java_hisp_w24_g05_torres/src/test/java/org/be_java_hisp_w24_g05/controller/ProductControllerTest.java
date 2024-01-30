package org.be_java_hisp_w24_g05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PostFollowedDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
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

import java.util.List;
import java.util.Objects;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private final Data data = new Data();

    @Test
    public void recentPostsOfFollowedUsersDateDescHappyPath() throws Exception {
        String url = "/products/followed/{userId}/list";
        Integer param = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();


        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));
        PostFollowedDto expectedPostsDTO = new PostFollowedDto(1,expectedPosts);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expectedPostsDTO)
        );

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    public void createPostHappyPath() throws Exception {
        String url = "/products/post";
        PostDto postDto = new PostDto(1, "26-01-2024", new ProductDto(
                1, "Teclado Gamer", "Gamer", "Racer", "Black", "Special Edition"), 100, 1500.50);

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(
                        objectMapper.writeValueAsString(postDto)
                )
                .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        PostDto expected = new PostDto(1, "26-01-2024", new ProductDto(
                1, "Teclado Gamer", "Gamer", "Racer", "Black", "Special Edition"), 100, 1500.50);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(expected)
        );
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    public void createPostValidationErrorTest() throws Exception {
        String url = "/products/post";
        PostDto postDto = new PostDto(1, "26-01-2024", new ProductDto(
                1, "Teclado Gamer", "Gamer", "Racer", "Black", "#$%"), 100, 1500.50);

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(
                        objectMapper.writeValueAsString(postDto)
                )
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentTypeExpected);
    }






}
