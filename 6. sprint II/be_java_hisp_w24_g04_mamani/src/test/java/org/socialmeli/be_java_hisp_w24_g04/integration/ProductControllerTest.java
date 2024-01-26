package org.socialmeli.be_java_hisp_w24_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.ProductDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
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
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void createPost() throws Exception {
        String url = "/products/post";

        ProductDTO productDTO = new ProductDTO(
                1,
                "Product 1",
                "Electronics",
                "ExampleBrand1",
                "Red",
                "Product notes 1"
        );

        UserPostDTO postDTO = new UserPostDTO(
                101,
                "10-01-2024",
                productDTO,
                1,
                49.99
        );

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(postDTO));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(new SingleResponseDTO(200, postDTO))
        );

        mockMvc
                .perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected);


    }

    @Test
    public void searchAllFollowedLastTwoWeeksTest() throws Exception {
        String url = "/products/followed/{userId}/list";
        Integer param = 101;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ProductDTO productDTO = new ProductDTO(
                3,
                "Product 3",
                "Home",
                "ExampleBrand3",
                "Green",
                "Product notes 3"
        );

        PostDTO postDTO = new PostDTO(
                102,
                3,
                "2024-01-12",
                productDTO,
                1,
                79.99
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(Arrays.asList(postDTO))
        );

        mockMvc
                .perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected);


    }
}
