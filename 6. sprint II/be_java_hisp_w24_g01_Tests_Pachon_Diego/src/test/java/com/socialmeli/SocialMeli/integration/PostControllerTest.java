package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.*;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    private final ProductPostRequestDTO productPostRequestDTOId204 = new ProductPostRequestDTO(
            204,
            "Wireless Earbuds",
            "Electronics",
            "Apple",
            "White",
            "Active noise cancellation, sweat-resistant"
    );
    private final ProductPostRequestDTO productPostRequestDTOId204_1 = new ProductPostRequestDTO(
            204,
            "Wireless Earbuds",
            "Electronics",
            "Apple",
            "White",
            "Active noise cancellation sweat resistant"
    );

    private final ProductPostRequestDTO productPostRequestDTOId205 = new ProductPostRequestDTO(
            205,
            "Backpack",
            "Outdoor",
            "Patagonia",
            "Green",
            "Durable and water-resistant"
    );
    private final CategoryPostRequestDTO categoryPostRequestDTOId3 = new CategoryPostRequestDTO(
            3,
            "Appliances"
    );


    @Test
    @DisplayName("Test list posts of the followed users")
    void listPostUserTest() throws Exception {

        Integer param = 101;

        LastestPostDTO expected= new LastestPostDTO(
                101,
                List.of(
                        new PostWithIdDTO(
                                105,
                                305,
                                LocalDate.of(2024, 1, 24),
                                productPostRequestDTOId205,
                                categoryPostRequestDTOId3,
                                89.99
                        ),
                        new PostWithIdDTO(
                                104,
                                304,
                                LocalDate.of(2024, 1, 23),
                                productPostRequestDTOId204,
                                categoryPostRequestDTOId3,
                                149.99
                        )
                )
        );
        //paso 1 - Construir request
        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list",param);

        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //paso 3 - Construir bodyExpected
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected));

        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //ActAndAssert
        //ejecutamos la peticion y comparamos el resultado con el esperado
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test tried to create post but bad request provided")
    void createPostTestBadRequest() throws Exception {

        PostRequestDTO newPostRequestDTO = new PostRequestDTO(
                -5,
                LocalDate.now(),
                productPostRequestDTOId204,
                categoryPostRequestDTOId3,
                150666666666.0

        );

        ErrorDTO expected = new ErrorDTO(
                "The following errors were found in the validations: "
                ,List.of(
                "User id must be greater than 0",
                "The maximum price per product is 10,000,000",
                "The notes field cannot contain special characters."));

        //paso 1 - Construir request
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .content(mapper.writeValueAsString(newPostRequestDTO))
                .contentType(MediaType.APPLICATION_JSON);

        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        //paso 3 - Construir bodyExpected
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected));

        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test createPost")
    void createPostTest() throws Exception {

        PostRequestDTO newPostRequestDTO = new PostRequestDTO(
                101,
                LocalDate.now(),
                productPostRequestDTOId204_1,
                categoryPostRequestDTOId3,
                150.0
        );

        PostResponseDTO expected = new PostResponseDTO(
                311, //Last id +1 in JSON file
                101,
                LocalDate.now().toString(),
                204,
                "Wireless Earbuds",
                3,
                "Appliances",
                150.0
        );

        //paso 1 - Construir request
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .content(mapper.writeValueAsString(newPostRequestDTO))
                .contentType(MediaType.APPLICATION_JSON);

        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //paso 3 - Construir contentExpected
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected));

        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);


    }

}