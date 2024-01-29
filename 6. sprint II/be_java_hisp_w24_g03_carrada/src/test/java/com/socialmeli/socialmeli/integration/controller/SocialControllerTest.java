package com.socialmeli.socialmeli.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.UserFollowedDto;
import com.socialmeli.socialmeli.utils.PostUtils;
import com.socialmeli.socialmeli.utils.UserUtils;
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

@SpringBootTest
@AutoConfigureMockMvc
public class SocialControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    UserUtils userUtils = new UserUtils();

    //region Desarrollo Individual
    @Test
    @DisplayName("Test getAllFollowed endpoint with valid userId and order ('name_asc').")
    public void getAllFollowedAscHappyPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_asc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        userFollowedList
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
    @Test
    @DisplayName("Test getAllFollowed endpoint with valid userId and order ('name_desc').")
    public void getAllFollowedDescHappyPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 4698;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_desc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(
                        userFollowedList
                )
        );

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    @DisplayName("Test getAllFollowed endpoint with an invalid userId")
    public void getAllFollowedSadPath() throws Exception {

        UserFollowedDto userFollowedList = userUtils.getUserFollowedList();

        //Request creation
        String url = "/users/{userId}/followed/list";
        Integer userId = 469;
        RequestBuilder request = MockMvcRequestBuilders.get(url,userId)
                .param("order", "name_asc");

        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //ContentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.jsonPath("$.message").value("No se encontro un usuario con el id " + userId);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected); //resultMatchers: status, body, contentType
    }

}
