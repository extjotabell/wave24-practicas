package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserBasicInfoDTO;
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


        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
         ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //act
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType
        //assert
    }

    @Test
    public void getUserFollowers() throws Exception {
        Integer param = 2;
        String url ="/users/{userId}/followers/list";
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        UserBasicInfoDTO userBasicInfoDTO1 = new UserBasicInfoDTO(6,"Usuario 6");
        UserBasicInfoDTO userBasicInfoDTO2 = new UserBasicInfoDTO(9,"Usuario 9");
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
        //act
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType
        //assert
    }
}
