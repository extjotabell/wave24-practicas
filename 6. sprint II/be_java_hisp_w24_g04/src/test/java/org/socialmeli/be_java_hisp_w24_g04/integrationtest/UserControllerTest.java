package org.socialmeli.be_java_hisp_w24_g04.integrationtest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterAll;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    UserFollowersDTO userFollowerDTO;
    UserFollowedDTO userFollowedDTO;
    UserFollowerCountDTO userFollowerCountDTO;
    SingleResponseDTO singleResponseDTOFollowers;
    SingleResponseDTO singleResponseDTOFollowed;
    SingleResponseDTO singleResponseDTOFollowerCount;

    @BeforeEach
    void setUp() {
        UserDTO userDTO1 = new UserDTO(101,"User1");
        UserDTO userDTO2 = new UserDTO(102,"User2");
        UserDTO userDTO3 = new UserDTO(103,"User3");
        Set<UserDTO> list = List.of(userDTO1,userDTO3, userDTO2).stream().collect(Collectors.toSet());
        Set<UserDTO> list2 = List.of(userDTO3).stream().collect(Collectors.toSet());
        userFollowerDTO = new UserFollowersDTO(102,"User2", list);
        singleResponseDTOFollowers = new SingleResponseDTO(200, userFollowerDTO);
        userFollowedDTO = new UserFollowedDTO(102,"User2", list2);
        singleResponseDTOFollowed = new SingleResponseDTO(200, userFollowedDTO);
        userFollowerCountDTO = new UserFollowerCountDTO(102,"User2", 3);
        singleResponseDTOFollowerCount = new SingleResponseDTO(200, userFollowerCountDTO);

    }

    @Test
    @DisplayName("Get followers test")
    public void getFollowersTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 102);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(singleResponseDTOFollowers));

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Get followed test")
    public void getFollowedTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", 102);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(singleResponseDTOFollowed));

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Get followers count test")
    public void getFollowersCountTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 102);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(singleResponseDTOFollowerCount));

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Follow test")
    public void followTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.post("/users//{userId}/follow/{userIdToFollow}", 104, 101);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Unfollow test")
    public void unfollowTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.post("/users//{userId}/unfollow/{userIdToFollow}", 104, 101);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andDo(MockMvcResultHandlers.print());
    }


}
