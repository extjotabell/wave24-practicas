package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserBasicInfoDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserRelationshipsDTO;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @Test
    public void getUserFollowersCount() throws Exception {
        //arrage
       Integer param = 1;

        String url = "/users/{userId}/followers/count";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        UserFollowersCountDTO expected = new UserFollowersCountDTO(1,"Usuario 1",4);
        //act accert
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
         ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType

    }

    @Test
    public void getUserFollowers() throws Exception {
        //Arrage
        Integer param = 2;
        String url ="/users/{userId}/followers/list";
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        List<UserBasicInfoDTO> Followers = new ArrayList<>(List.of(
                new UserBasicInfoDTO(6, "Usuario 6"),
                new UserBasicInfoDTO(9, "Usuario 9")
        ));
        UserRelationshipsDTO expected = new UserRelationshipsDTO(2,"Usuario 2", Followers, true);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //act assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType

    }
    @Test
    public void followUser() throws Exception {
//Arrage
        String url = "/users/{userId}/follow/{userIdToFollow}";
        Integer param1 = 1;
        Integer param2 = 8;

        RequestBuilder request = MockMvcRequestBuilders.post(url,param1,param2);

        ResultMatcher status = MockMvcResultMatchers.status().isOk();
//act acert
        mockMvc.perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status);

    }
    @Test
    public void getUserFollowed() throws Exception {
        String url = "/users/{userId}/followed/list";
        Integer param = 1;

        RequestBuilder request = MockMvcRequestBuilders.get(url,param);

        List<UserBasicInfoDTO> Followeds = new ArrayList<>(List.of(
                new UserBasicInfoDTO(2, "Usuario 2"),
                new UserBasicInfoDTO(3, "Usuario 3"),
                new UserBasicInfoDTO(8, "Usuario 8")
        ));
        UserRelationshipsDTO expected = new UserRelationshipsDTO(1,"Usuario 1", Followeds, false);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //act assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType
    }
}
