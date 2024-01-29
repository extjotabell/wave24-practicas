package org.be_java_hisp_w24_g05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.PostFollowedDto;
import org.be_java_hisp_w24_g05.dto.UserFollowedDto;
import org.be_java_hisp_w24_g05.entity.Post;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private Data data = new Data();
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void recentPostsOfFollowedUsersDateDescPositiveTest() throws Exception {
        // Arrange
        String url = "/products/followed/{userId}/list";
        Integer userId = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(url, userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();


        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));
        PostFollowedDto expectedPostsDTO = new PostFollowedDto(1,expectedPosts);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expectedPostsDTO)
        );

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(statusExpected) // verifica el status
                //.andExpect(bodyExpected) // verifica el body
                //.andExpect(contentTypeExpected); // verifica el tipo
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }


}
