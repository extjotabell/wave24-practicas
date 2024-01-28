package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.SocialMeli.dto.responseDTO.ExceptionDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import com.socialmeli.SocialMeli.utils.UserConstants;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final  UserFollowerDTO USER1DTO= new UserFollowerDTO(101, "Alice Johnson",
            List.of(new FollowerDTO(104, "David Williams"),
                    new FollowerDTO(105, "Eva Martinez"),
                    new FollowerDTO(102, "Bob Smith")));



    private final  UserFollowerDTO USER1DTO2= new UserFollowerDTO(101, "Alice Johnson",
            List.of(new FollowerDTO(102, "Bob Smith"),
                    new FollowerDTO(103, "Charlie Brown")));




    @Autowired
    ObjectMapper mapper = new ObjectMapper();
    @Test
    @DisplayName("T-Integration : followerCountOk")
    public void followerCountOk() throws Exception {


        //request
        Integer param = 101;
        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",param);

        //expected
        UserFollowersCountDTO expected = new UserFollowersCountDTO(
                101,
                "Alice Johnson",
                2);

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().isOk(); //verificacion estqatus
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected)); //verificacion contenido string to json
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON); //verificacion tipo de contenido

        mockMvc.perform(request) //ejecutar la request
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());




    }

    @Test
@DisplayName("T-Integration : followerCountSad")
    public void followerCountSad() throws Exception {


        //request
        Integer param = 10;
        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",param);

        //expected
        UserNotFoundException userNotFoundException = new UserNotFoundException("User not found");
        ExceptionDTO expected = new ExceptionDTO(userNotFoundException.getMessage());

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().is(404); //verificacion estqatus
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected)); //verificacion contenido string to json
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON); //verificacion tipo de contenido

        mockMvc.perform(request) //ejecutar la request
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());




    }

    @Test
    @DisplayName("T-Integration : followUserOk")
    public void followUserOk() throws Exception {


        // Request parameters
        Integer userId = 101;
        Integer userIdToFollow = 102;

        // Request
        RequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Expected
        UserFollowerDTO expected = USER1DTO;

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("T-Integration : followUserSad")
    public void followUserSad() throws Exception {


        // Request parameters
        Integer userId = 101;
        Integer userIdToFollow = 101;

        // Request
        RequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Expected
        ExceptionDTO expected = new ExceptionDTO("You can't follow yourself");

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().is(400);
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    @DisplayName("T-Integration : unfollowUserSad")
    public void unfollowUserSad() throws Exception {
        // Request parameters
        Integer userId = 101;
        Integer userIdToUnFollow = 102;

        // Request
        RequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Expected
        ExceptionDTO expected = new ExceptionDTO("User not followed");

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().is(400);
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());

    }
    @Test
    @DisplayName("T-Integration : followersListOk")
    public void followersListOk() throws Exception {


        // Request parameters
        Integer userId = 101;
        String order = "name_asc";

        // Request
        // Request
        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                .param("order", order)  // Add parameters using .param()
                .contentType(MediaType.APPLICATION_JSON);

        // Expected
        UserFollowerDTO expected = USER1DTO2;

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("T-Integration : followersListSad")
    public void followersListSad() throws Exception {


        // Request parameters
        Integer userId = 101;
        String order = "name_";

        // Request
        RequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                .param("order", order)  // Add parameters using .param()
                .contentType(MediaType.APPLICATION_JSON);

        // Expected
        ExceptionDTO expected = new ExceptionDTO("The 'order' parameter is incorrect");

        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().is(400);
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print());

    }

}
