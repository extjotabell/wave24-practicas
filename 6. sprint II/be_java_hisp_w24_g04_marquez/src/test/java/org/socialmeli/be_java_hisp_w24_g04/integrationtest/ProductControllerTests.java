package org.socialmeli.be_java_hisp_w24_g04.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
import org.socialmeli.be_java_hisp_w24_g04.exception.InvalidTimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    Clock clock;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        Instant fixedInstant = Instant.parse("2024-01-27T00:00:00Z");
        when(clock.instant()).thenReturn(fixedInstant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());
    }

    @Test
    public void testSearchAllFollowedLastTwoWeeks() throws Exception {
        // Arrange
        Integer userId = 102;
        String order = "date_desc";

        List<PostDTO> expectedPostDTOFor102Desc = List.of(
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
                        89.99),
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
                        4,
                        "2024-01-13",
                        new ProductDTO(4,
                                "Product 4",
                                "Electronics",
                                "ExampleBrand4",
                                "Black",
                                "Product notes 4"),
                        2,
                        39.99)
        );

        String url = "/products/followed/{userId}/list?order={order}";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId, order);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expectedPostDTOFor102Desc));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    public void testSearchAllFollowedLastTwoWeeksInvalid() throws Exception {
        // Arrange
        Integer userId = 0;
        String order = "date_desc";

        ErrorResponseDTO expected = new ErrorResponseDTO(404, "User not found.");

        String url = "/products/followed/{userId}/list?order={order}";
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId, order);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    public void testCreateUserPost() throws Exception {
        // Arrange
        UserPostDTO post = new UserPostDTO(101,"26-01-2024",new ProductDTO(1,"Product 1","Electronics","ExampleBrand1","Black","Product notes 1"),1,39.99);
        SingleResponseDTO expected = new SingleResponseDTO(200, post);
        String postJson = mapper.writeValueAsString(post);

        String url = "/products/post";
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    public void testCreateUserPostInvalidUserId() throws Exception {
        // Arrange
        UserPostDTO post = new UserPostDTO(0,"26-01-2024",new ProductDTO(1,"Product 1","Electronics","ExampleBrand1","Black","Product notes 1"),1,39.99);
        ErrorResponseDTO expected = new ErrorResponseDTO(400, "Couldn't create user's post. Please, try again with a valid user ID.");
        String postJson = mapper.writeValueAsString(post);

        String url = "/products/post";
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }

    @Test
    public void testCreateUserPostInvalidTime() throws Exception {
        // Arrange
        UserPostDTO post = new UserPostDTO(101,"Monday",new ProductDTO(1,"Product 1","Electronics","ExampleBrand1","Black","Product notes 1"),1,39.99);
        String postJson = mapper.writeValueAsString(post);

        String url = "/products/post";
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);

        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidTimeException))
                .andExpect(result -> assertEquals("Invalid date format. It should be dd-MM-yyyy", result.getResolvedException().getMessage()));
    }
}