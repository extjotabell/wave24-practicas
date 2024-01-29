package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostWithIdDTO;
import com.socialmeli.SocialMeli.repository.implementations.PostRepository;
import com.socialmeli.SocialMeli.repository.implementations.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostRepository postRepository; // Assuming you have a UserRepository for database operations


    @BeforeEach
    public void setup() throws Exception {
        //Load the database before each test
        //Non-optimal solution, but it works
        postRepository.loadDataBase();
    }

        @Test
        @DisplayName("Create Post Test")
        public void createPostTestOk () throws Exception {
            // Arrange
            String url = "/products/post";

            //Storing date
            LocalDate date = LocalDate.now();
            //DTO for response and request
            PostRequestDTO postRequest = new PostRequestDTO(
                    101, // Example user ID
                    date,
                    new ProductPostRequestDTO(101, "Product 1", "Description 1", "Brand","BR", "BRL"),
                    new CategoryPostRequestDTO(10, "Clothing"),
                    999.99
            );

            // Mock expected response
            PostResponseDTO expectedResponse = new PostResponseDTO(311, 101, date.toString(), 101,"Product 1", 10,"Clothing", 999.99); // Populate with expected data
            String requestBody = objectMapper.writeValueAsString(postRequest);
            ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
            ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse));

            // Act & Assert
            mockMvc.perform(MockMvcRequestBuilders.post(url)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(statusExpected)
                    .andExpect(bodyExpected);
        }

        //Default order is date_desc
    @Test
    @DisplayName("List Post User Test with Date Descending Order")
    public void listPostUserTest() throws Exception {
        // Arrange
        int userId = 101; // Example user ID
        String url = "/products/followed/" + userId + "/list?order=date_desc";

        List<PostWithIdDTO> posts = Arrays.asList(
                new PostWithIdDTO(105, 305, LocalDate.parse("24-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        new ProductPostRequestDTO(205, "Backpack", "Outdoor", "Patagonia", "Green", "Durable and water-resistant"),
                        new CategoryPostRequestDTO(3, "Appliances"), 89.99),
                new PostWithIdDTO(104, 304, LocalDate.parse("23-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        new ProductPostRequestDTO(204, "Wireless Earbuds", "Electronics", "Apple", "White", "Active noise cancellation, sweat-resistant"),
                        new CategoryPostRequestDTO(3, "Appliances"), 149.99),
                new PostWithIdDTO(102, 302, LocalDate.parse("21-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        new ProductPostRequestDTO(202, "Running Shoes", "Footwear", "Nike", "Blue", "Ideal for long-distance running"),
                        new CategoryPostRequestDTO(2, "Footwear"), 129.99)
        );

        LastestPostDTO expectedResponse = new LastestPostDTO(userId, posts);


        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse)));;
    }
}

