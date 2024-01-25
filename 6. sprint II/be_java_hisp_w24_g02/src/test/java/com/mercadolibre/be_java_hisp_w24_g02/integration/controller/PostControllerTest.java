package com.mercadolibre.be_java_hisp_w24_g02.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreateProductDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDto;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Test add new product post")
    public void testAddNewProductPost() throws Exception {
        // Arrange
        String uriTemplate = "/products/post";
        CreatePostDTO createPostDTO = new CreatePostDTO(
                1,
                "24-01-2024",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                1,
                22.9
        );
        RequestBuilder request = MockMvcRequestBuilders.post(uriTemplate)
                .content(mapper.writeValueAsString(createPostDTO))
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected);
    }

    @Test
    @DisplayName("Test add new product post with invalid data")
    public void testAddNewProductPostWithInvalidData() throws Exception {
        // Arrange
        String uriTemplate = "/products/post";
        CreatePostDTO createPostDTO = new CreatePostDTO(
                1,
                "invalid date",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                1,
                22.9
        );
        RequestBuilder request = MockMvcRequestBuilders.post(uriTemplate)
                .content(mapper.writeValueAsString(createPostDTO))
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected);
    }

    @Test
    @DisplayName("Test add new product post with invalid data id minor of 0")
    public void testAddNewProductPostWithInvalidDataIdIsMinor() throws Exception {
        // Arrange
        String uriTemplate = "/products/post";
        CreatePostDTO createPostDTO = new CreatePostDTO(
                -100,
                "invalid date",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                1,
                22.9
        );
        RequestBuilder request = MockMvcRequestBuilders.post(uriTemplate)
                .content(mapper.writeValueAsString(createPostDTO))
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected);
    }

    @Test
    @DisplayName("Max price per product is 10.000.000")
    public void testAddNewProductPostWithInvalidDataMaxPricePerProduct() throws Exception {
        // Arrange
        String uriTemplate = "/products/post";
        CreatePostDTO createPostDTO = new CreatePostDTO(
                1,
                "24-01-2024",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                1,
                10000001.0
        );
        RequestBuilder request = MockMvcRequestBuilders.post(uriTemplate)
                .content(mapper.writeValueAsString(createPostDTO))
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected);
    }

    @Test
    @DisplayName("Test get users followed post by userId")
    public void testGetUsersFollowedPostByUserId() throws Exception {
        // Arrange
        String uriTemplate = "/products/followed/1/list";
        PostDto postDto2 = new PostDto(
                2,
                2,
                LocalDate.of(2024, 1, 24),
                new Product(
                        1002,
                        "Smartphone ABC",
                        "Smartphone",
                        "ABC",
                        "Black",
                        "Último modelo de smartphone con cámara de alta resolución"
                ),
                2,
                799.99
        );
        PostDto postDto12 = new PostDto(
                12,
                3,
                LocalDate.of(2024, 1, 25),
                new Product(
                        1010,
                        "Altavoces ABC",
                        "Altavoces",
                        "XYZ",
                        "Black",
                        "Altavoces bluetooth de alta fidelidad"
                ),
                10,
                129.99
        );
        PostDto postDto11 = new PostDto(
                11,
                2,
                LocalDate.of(2024, 10, 20),
                new Product(
                        1010,
                        "Reproductor de Blu-ray XYZ",
                        "Reproductor de Blu-ray",
                        "XYZ",
                        "Black",
                        "Reproductor de Blu-ray 4K con funciones inteligentes"
                ),
                10,
                129.99
        );
        UserFollowedsPostsDTO userFollowedsPostsDTOExpected = new UserFollowedsPostsDTO(1, new ArrayList<>(List.of(postDto2, postDto12, postDto11)));
        RequestBuilder request = MockMvcRequestBuilders.get(uriTemplate)
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(userFollowedsPostsDTOExpected));

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("Test get users followed post by userId when user id not found")
    public void testGetUsersFollowedPostByUserIdWhenUserIdNotFound() throws Exception {
        // Arrange
        String uriTemplate = "/products/followed/100/list";
        RequestBuilder request = MockMvcRequestBuilders.get(uriTemplate)
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected);
    }

}
