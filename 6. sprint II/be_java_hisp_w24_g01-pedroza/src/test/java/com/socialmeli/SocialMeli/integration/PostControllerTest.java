package com.socialmeli.SocialMeli.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.ExceptionDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//1
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    //2 mock MVC: Para REQUESTS
    @Autowired
    MockMvc mockMvc;


    private final PostRequestDTO param = new PostRequestDTO(
            101,
            LocalDate.now().minusDays(5),
            new ProductPostRequestDTO(
                    205,
                    "Backpack",
                    "Outdoor",
                    "Patagonia",
                    "Green",
                    "Durable and water resistant"
            ),
            new CategoryPostRequestDTO(
                    3,
                    "Appliances"
            ),
            89.99

    );

    private final PostRequestDTO param2= new PostRequestDTO(
            222,
            LocalDate.now().minusDays(5),
            new ProductPostRequestDTO(
                    205,
                    "Backpack",
                    "Outdoor",
                    "Patagonia",
                    "Green",
                    "Durable and water resistant"
            ),
            new CategoryPostRequestDTO(
                    3,
                    "Appliances"
            ),
            89.99

    );
    private final PostResponseDTO expected = new PostResponseDTO(
            311,
            101,
            String.valueOf(LocalDate.now().minusDays(5)),
            205,
            "Backpack",
            3,
            "Appliances",
            89.99
    );


    @Autowired
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule()); //object to json string

    //CREARE POST : URL , body , status , body , content type


    @Test
    @DisplayName("T-Integration : Create post test OK")
    public void createPostTestOK() throws Exception {

        //REQUEST POST
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .content(mapper.writeValueAsString(param)).contentType(MediaType.APPLICATION_JSON); //string

        //EXPECTED
        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().isOk(); //verificacion estqatus
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected)); //verificacion contenido string to json
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON); //verificacion tipo de contenido

        mockMvc.perform(request) //ejecutar la request
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print()); //accion : primer


    }

    @Test
    @DisplayName("T-Integration : Create post test Sad")
    public void createPostTestSad() throws Exception {

        //REQUEST POST
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .content(mapper.writeValueAsString(param2)).contentType(MediaType.APPLICATION_JSON); //string

        //EXPECTED

        UserNotFoundException userNotFoundException = new UserNotFoundException("User id: "+param2.user_id()+ " not found.");
        ExceptionDTO exceptionDTO = new ExceptionDTO(userNotFoundException.getMessage());
        ResultMatcher resultMatcherStatus = MockMvcResultMatchers.status().is(404); //verificacion estqatus
        ResultMatcher resultMatcherBody = MockMvcResultMatchers.content().json(mapper.writeValueAsString(exceptionDTO)); //verificacion contenido string to json
        ResultMatcher resultMatcherContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON); //verificacion tipo de contenido

        mockMvc.perform(request) //ejecutar la request
                .andExpect(resultMatcherStatus)
                .andExpect(resultMatcherBody)
                .andExpect(resultMatcherContentType)
                .andDo(MockMvcResultHandlers.print()); //accion : primer


    }

}
