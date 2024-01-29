package org.socialmeli.be_java_hisp_w24_g04.integrationtest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.be_java_hisp_w24_g04.controller.ProductController;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Clock clock;

    ObjectWriter writer = new ObjectMapper().writer();
    ProductDTO productDTO4 = new ProductDTO(4,"Product 4","Electronics","ExampleBrand4","Black","Product notes 4");
    ProductDTO productDTO5 = new ProductDTO(5,"Product 5","Clothing","ExampleBrand5","White","Product notes 5");
    ProductDTO productDTO6 = new ProductDTO(6,"Product 6","Home","ExampleBrand6","Yellow","Product notes 6");

    @BeforeEach
    public void setUp() {
        Instant fixedInstant = Instant.parse("2024-01-27T00:00:00Z");
        when(clock.instant()).thenReturn(fixedInstant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());
    }

    @Test
    @DisplayName("Testing searchAllFollowedLastWeek endpoint with ascending sorting")
    public void testSearchAllFollowedLastTwoWeeksAsc() throws Exception {
        List<PostDTO> expected = List.of(
                new PostDTO(103, 4, "2024-01-13", productDTO4, 2, 39.99),
                new PostDTO(103, 5, "2024-01-14", productDTO5, 1, 59.99),
                new PostDTO(103, 6, "2024-01-15", productDTO6, 2, 89.99)
        );
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list?order=date_asc", 102);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContent, expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName("Testing searchAllFollowedLastWeek endpoint with descending sorting")
    public void testSearchAllFollowedLastTwoWeeksDesc() throws Exception {
        List<PostDTO> expected = List.of(
                new PostDTO(103, 6, "2024-01-15", productDTO6, 2, 89.99),
                new PostDTO(103, 5, "2024-01-14", productDTO5, 1, 59.99),
                new PostDTO(103, 4, "2024-01-13", productDTO4, 2, 39.99)
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list?order=date_desc", 102);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expectedContent)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType);
    }

    @Test
    @DisplayName("Testing searchAllFollowedLastWeek endpoint with invalid user")
    public void testSearchAllFollowedLastTwoWeeksInvalidUser() throws Exception {
        ErrorResponseDTO expected = new ErrorResponseDTO(404, "User not found.");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 9999);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContent, expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName("Testing create user post")
    public void testCreateUserPost() throws Exception {
        ProductDTO product = new ProductDTO(99,"Product X","Electronics","ExampleBrandX","Black","Product notes X");
        UserPostDTO dto = new UserPostDTO(102, "01-01-2024",product,2,30.99);
        SingleResponseDTO expected = new SingleResponseDTO(200, dto);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").content(writer.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContent, expectedContentType, expectedStatus);
    }

    @Test
    @DisplayName("Testing create user post with invalid date")
    public void testCreateUserPostWithInvalidDate() throws Exception {
        ProductDTO product = new ProductDTO(99,"Product X","Electronics","ExampleBrandX","Black","Product notes X");
        UserPostDTO dto = new UserPostDTO(102, "2024-01-01",product,2,30.99);
        ErrorResponseDTO expected = new ErrorResponseDTO(400, "Invalid date format. It should be dd-MM-yyyy");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").content(writer.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContent, expectedContentType, expectedStatus);
    }

    @Test
    @DisplayName("Tesing create user post with invalid user")
    public void testCreateUserPostWithInvalidUser() throws Exception {
        ProductDTO product = new ProductDTO(99,"Product X","Electronics","ExampleBrandX","Black","Product notes X");
        UserPostDTO dto = new UserPostDTO(666, "2024-01-01",product,2,30.99);
        ErrorResponseDTO expected = new ErrorResponseDTO(400, "Couldn't create user's post. Please, try again with a valid user ID.");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").content(writer.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContent, expectedContentType, expectedStatus);
    }
}
