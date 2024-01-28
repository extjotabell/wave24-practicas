package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.*;
import com.socialmeli.SocialMeli.service.implementations.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createPostReturnsOkStatusWhenPostIsValid() throws Exception {
        PostRequestDTO postDTO = new PostRequestDTO(101,
                LocalDate.of(2024, 1, 20),
                new ProductPostRequestDTO(
                        201,
                        "Smartphone",
                        "Electronics",
                        "Samsung",
                        "Black",
                        "6.5-inch display, 128GB storage"),
                new CategoryPostRequestDTO(
                        1,
                        "Electronics"),
                799.99);
        String url = "/products/post";

        Mockito.when(postService.createPost(postDTO)).thenReturn(new PostResponseDTO(301,
                101,
                "20-01-2024",
                201,
                "Smartphone",
                1,
                "Electronics",
                799.99));

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void createPostReturnsBadRequestWhenPostIsInvalid() throws Exception {
        PostRequestDTO postDTO = new PostRequestDTO(101, LocalDate.of(2024, 1, 20),
                new ProductPostRequestDTO(
                        null,
                        "Smartphone",
                        null,
                        "Samsung",
                        "Black",
                        "6.5-inch display, 128GB storage"),
                new CategoryPostRequestDTO(
                        12,
                        "Electronics"),
                799.99);
        String url = "/products/post";

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listPostUserReturnsOkStatusWhenUserIdIsValid() throws Exception {
        Integer userId = 101;
        String order = "date_desc";
        String url = "/products/followed/{userId}/list";

        Mockito.when(postService.getLastestPost(userId, order)).thenReturn(new LastestPostDTO(101,
                List.of(new PostWithIdDTO(
                        104,
                        301,
                        LocalDate.now().minusDays(6),
                        new ProductPostRequestDTO(
                                201,
                                "Smartphone",
                                "Electronics",
                                "Samsung",
                                "Black",
                                "6.5-inch display, 128GB storage"
                        ),
                        new CategoryPostRequestDTO(
                                1,
                                "Electronics"
                        ),
                        799.99
                ))));

        mockMvc.perform(MockMvcRequestBuilders.get(url, userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void listPostUserReturnsBadRequestWhenUserIdIsInvalid() throws Exception {
        Integer invalidUserId = -1;
        String order = "date_desc";
        String url = "/products/followed/{userId}/list";

        mockMvc.perform(MockMvcRequestBuilders.get(url, invalidUserId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
