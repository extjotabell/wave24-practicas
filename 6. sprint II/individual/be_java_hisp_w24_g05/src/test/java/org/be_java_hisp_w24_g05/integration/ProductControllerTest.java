package org.be_java_hisp_w24_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    Data data = new Data();

    @Test
    public void recentPostsOfFollowedUsersHappyPath() throws Exception {
        // Arrange

        // paso 1 - request
        String url = "/products/followed/{userId}/list";
        Integer userId = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = status().isOk();

        // paso 3 - construir el expected body

        List<Post> expected = Arrays.asList(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));
        PostFollowedDto expectedDTO = new PostFollowedDto(userId, expected);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expectedDTO)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verifica el status
                .andExpect(bodyExpected) // verifica el body
                .andExpect(contentTypeExpected); // verifica el tipo


    }
    @Test
    @DisplayName("recent posts of followed users sad path")
    public void recentPostsOfFollowedUsersSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/products/followed/{userId}/list";
        Integer userId = 100;

        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        // step 3 - build expected body
        ExceptionDto expected = new ExceptionDto("User not found");

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
    @DisplayName("make post sad path")
    public void makePostSadPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/products/post";
        Integer userId = 1;
        String date = "";
        Integer productId = 1;
        String productName = "Silla Gamer";
        String type = "Gamer";
        String brand = "Racer";
        String color = "Black";
        String notes = "Special Edition";
        Integer category = 100;
        Double price = 1500.50;

        PostDto postDto = new PostDto(userId, date, new ProductDto(
                productId, productName,type, brand, color, notes), category, price);

        RequestBuilder request = MockMvcRequestBuilders.post(url).content(mapper.writeValueAsString(postDto)).contentType(MediaType.APPLICATION_JSON);


        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // step 3 - build expected body
        ErrorDto expected = new ErrorDto("Se encontraron los siguientes errores en las validaciones: ",
                Arrays.asList("La fecha no debe estar vacía"));

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
    @DisplayName("make post happy path")
    public void makePostHappyPath() throws Exception {
        // Arrange

        // step 1 - request
        String url = "/products/post";
        Integer userId = 1;
        String date = "29-04-2024";
        Integer productId = 1;
        String productName = "Silla Gamer";
        String type = "Gamer";
        String brand = "Racer";
        String color = "Black";
        String notes = "Special Edition";
        Integer category = 100;
        Double price = 1500.50;

        PostDto postDto = new PostDto(userId, date, new ProductDto(
                productId, productName,type, brand, color, notes), category, price);

        RequestBuilder request = MockMvcRequestBuilders.post(url).content(mapper.writeValueAsString(postDto)).contentType(MediaType.APPLICATION_JSON);



        // step 2 - build expected status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // step 3 - build expected body

        PostDto expected= postDto;
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