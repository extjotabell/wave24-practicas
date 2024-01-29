package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    private final CreateProductDTO product1 = new CreateProductDTO(
            1,
            "Silla Gamer",
            "Gamer",
            "Racer",
            "Red & Black",
            "Special Edition"
    );
    private final CreatePostDTO post1 = new CreatePostDTO(
            1,
            "29-04-2021",
            product1,
            100,
            1500.50);


    @Test
    @DisplayName("Adding new post, happy path.")
    public void addNewProductPostHappyPath() throws Exception {

        //arrange

        // paso 1 - request

        String url = "/products/post";

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(mapper.writeValueAsString(post1))
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // Act and Assert
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Listing all post from an user from last 2 weeks, happy path with date Asc sorting.")
    public void getUserFollowedPostHappyPathDateAsc () throws Exception {

        //arrange

        //paso 1 Request

        String url = "/products/followed/{userId}/list";
        String pathVariable = "1";
        String requestParam = "date_asc";
        RequestBuilder request = MockMvcRequestBuilders.get(url, pathVariable)
                .param("order", requestParam);

        // paso 2 construir el expected del status

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 construir el expected body

        UserFollowedsPostsDTO expected = new UserFollowedsPostsDTO(
                1,
                List.of(
                        new PostDto(
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
                        ),
                        new PostDto(
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
                        ),
                        new PostDto(
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
                        )
                )
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        // paso 4 construir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act and assert

        mockMvc.perform(request).andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
}
