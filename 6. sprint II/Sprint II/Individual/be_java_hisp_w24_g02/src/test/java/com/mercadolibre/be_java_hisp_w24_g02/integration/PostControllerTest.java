package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreateProductDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDto;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import java.util.Arrays;
import java.util.List;
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getUserFollowed() throws Exception {
        Integer param = 1;
        String url = "/products/followed/{userId}/list";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        UserFollowedsPostsDTO userFollowerPostExpected = new UserFollowedsPostsDTO(1,
                List.of(new PostDto(2,2, LocalDate.of(2024,1,24),
                        new Product(
                                1002,
                                "Smartphone ABC",
                                "Smartphone",
                                "ABC",
                                "Black",
                                "Último modelo de smartphone con cámara de alta resolución"
                        ),
                        2, 799.99),
                        new PostDto(11,2,LocalDate.of(2024,10,20),
                                new Product(
                                        1010,
                                        "Reproductor de Blu-ray XYZ",
                                        "Reproductor de Blu-ray",
                                        "XYZ",
                                        "Black",
                                        "Reproductor de Blu-ray 4K con funciones inteligentes"
                                ),
                        10,129.99),

                        new PostDto(12,3,LocalDate.of(2024,01,25),
                                new Product(
                                        1010,
                                        "Altavoces ABC",
                                        "Altavoces",
                                        "XYZ",
                                        "Black",
                                        "Altavoces bluetooth de alta fidelidad"
                                ),
                                10,129.99)

                )
        );
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(userFollowerPostExpected)
        );
        ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //act
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType
        //assert
    }
    @Test
    public void addNewProductPost() throws Exception {
        String url = "/products/post";

        CreatePostDTO requestBody = new CreatePostDTO(1,"29-04-2021",
                new CreateProductDTO(1,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Red & Black",
                        "Special Edition"),
                        100,
                        1500.50);

        RequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).
                content(mapper.writeValueAsString(requestBody));

        ResultMatcher status = MockMvcResultMatchers.status().isOk();


        mockMvc.perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status);
    }


}
