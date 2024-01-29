package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostWithIdDTO;
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

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void createPostTest() throws Exception {

        //arrange
        String url = "/products/post";
        PostRequestDTO requestDTO = new PostRequestDTO(
                101,
                LocalDate.of(2021, 4, 20),
                new ProductPostRequestDTO(
                        1,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Red y Black",
                        "Special Edition"
                ),
                new CategoryPostRequestDTO(
                        2,
                        "Tecnologia"
                ),
                1500.50
        );

        PostResponseDTO expected = new PostResponseDTO(
                311,
                101,
                "2021-04-20",
                1,
                "Silla Gamer",
                2, "Footwear",
                1500.50);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(mapper.writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo

    }

    @Test
    public void listPostUserTest() throws Exception {

        //arrange
        String url = "/products/followed/{userId}/list";
        Integer param = 101;
        String reqParam = "date_asc";

        LastestPostDTO expected = new LastestPostDTO(
                param,
                List.of(
                        new PostWithIdDTO(
                                105,
                                305,
                                LocalDate.of(2024, 1, 24),
                                new ProductPostRequestDTO(
                                        205,
                                        "Backpack",
                                        "Outdoor",
                                        "Patagonia",
                                        "Green",
                                        "Durable and water-resistant"
                                ),
                                new CategoryPostRequestDTO(
                                        3,
                                        "Appliances"
                                ),
                                89.99
                        ),
                        new PostWithIdDTO(
                                102,
                                302,
                                LocalDate.of(2024, 1, 21),
                                new ProductPostRequestDTO(
                                        202,
                                        "Running Shoes",
                                        "Footwear",
                                        "Nike",
                                        "Blue",
                                        "Ideal for long-distance running"
                                ),
                                new CategoryPostRequestDTO(
                                        2,
                                        "Footwear"
                                ),
                                129.99
                        )
                )

        );

        RequestBuilder request = MockMvcRequestBuilders.get(url,param,reqParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo
    }
}