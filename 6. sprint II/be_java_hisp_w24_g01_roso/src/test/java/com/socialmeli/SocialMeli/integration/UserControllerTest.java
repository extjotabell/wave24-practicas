package com.socialmeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowedDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
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

    @Autowired
    ObjectMapper mapper;

    private final List<FollowerDTO> FOLLOWERSDTO = List.of(
            new FollowerDTO(102, "Bob Smith"),
            new FollowerDTO(103, "Charlie Brown"));

    private final List<FollowerDTO> FOLLOWEDDTO = List.of(
            new FollowerDTO(104, "David Williams"),
            new FollowerDTO(105, "Eva Martinez"));

    private final UserFollowerDTO USER1DTO = new UserFollowerDTO(
            101,
            "Alice Johnson",
            FOLLOWERSDTO);
    private final UserFollowedDTO USER1WITHFOLLOWEDDTO = new UserFollowedDTO(
            101,
            "Alice Johnson",
            FOLLOWEDDTO);

    @Test
    public void getFollowersCountTest() throws Exception {
        //arrange
        String url = "/users/{idUser}/followers/count";
        Integer param = 101;
        String name = "Alice Johnson";

        UserFollowersCountDTO expected = new UserFollowersCountDTO(101, name, 2);

        RequestBuilder request = MockMvcRequestBuilders.get(url,param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo
    }

    @Test
    public void unfollowTest() throws Exception {
        //arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer param1 = 101;
        Integer param2 = 104;

        RequestBuilder request = MockMvcRequestBuilders.post(url, param1, param2)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        // act && assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);//verifica el status

    }

    @Test
    public void unfollowBadRequestTest() throws Exception {
        //arrange
        String url = "/users/{userId}/unfollow/{userIdToUnfollow}";
        Integer param1 = 101;
        Integer param2 = 101;

        RequestBuilder request = MockMvcRequestBuilders.post(url, param1, param2)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        // act && assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);//verifica el status

    }

    @Test
    public void getFollowersOfUserTest() throws Exception {
        //arrange
        String url = "/users/{userId}/followers/list";
        Integer param = 101;
        String reqParam = "name_asc";

        RequestBuilder request = MockMvcRequestBuilders.get(url,param,reqParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(USER1DTO)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo
    }

    @Test
    public void followUserTest() throws Exception {
        //arrange
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer param1 = 101;
        Integer param2 = 102;

        List<FollowerDTO> followerDTO = List.of(
                new FollowerDTO(105, "Eva Martinez"),
                new FollowerDTO(102, "Bob Smith"));

        UserFollowerDTO expected = new UserFollowerDTO(
                param1,
                "Alice Johnson",
                followerDTO);

        RequestBuilder request = MockMvcRequestBuilders.post(url,param1,param2);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo
    }

    @Test
    public void getFollowedTest() throws Exception {
        //arrange
        String url = "/users/{userId}/followed/list";
        Integer param = 101;
        String reqParam = "name_asc";
        UserFollowedDTO expected = USER1WITHFOLLOWEDDTO;

        RequestBuilder request = MockMvcRequestBuilders.get(url,param,reqParam);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo
    }
}
