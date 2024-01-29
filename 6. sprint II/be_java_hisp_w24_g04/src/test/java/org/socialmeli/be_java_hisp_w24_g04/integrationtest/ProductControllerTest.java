package org.socialmeli.be_java_hisp_w24_g04.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    @Autowired
    ObjectMapper mapper;

    List<PostDTO> expectedPostDTOFor102;
    UserPostDTO postDTO;
    SingleResponseDTO singleResponseDTO;

    @BeforeEach
    void setUp() {
        expectedPostDTOFor102 = List.of(
                new PostDTO(103,
                        4,
                        "2024-01-13",
                        new ProductDTO(4,
                                "Product 4",
                                "Electronics",
                                "ExampleBrand4",
                                "Black",
                                "Product notes 4"),
                        2,
                        39.99),
                new PostDTO(103,
                        5,
                        "2024-01-14",
                        new ProductDTO(5,
                                "Product 5",
                                "Clothing",
                                "ExampleBrand5",
                                "White",
                                "Product notes 5"),
                        1,
                        59.99),
                new PostDTO(103,
                        6,
                        "2024-01-15",
                        new ProductDTO(6,
                                "Product 6",
                                "Home",
                                "ExampleBrand6",
                                "Yellow",
                                "Product notes 6"),
                        2,
                        89.99)
        );

        postDTO = new UserPostDTO(103,
                "13-01-2024",
                new ProductDTO(4,
                        "Product 4",
                        "Electronics",
                        "ExampleBrand4",
                        "Black",
                        "Product notes 4"),
                2,
                39.99);
        singleResponseDTO = new SingleResponseDTO(200, postDTO);
    }

    @Test
    @DisplayName("Search all followed post from last two weeks test")
    public void searchAllFollowedLastTwoWeeksTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 102);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedPostDTOFor102));

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Create post test")
    public void postTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .content(writer.writeValueAsString(postDTO)).contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(singleResponseDTO));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, contentType, bodyExpected);
    }

}
