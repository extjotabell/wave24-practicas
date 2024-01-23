package com.exceptions.starwars.integration;

import com.exceptions.starwars.dto.PersonajeCompleteDTO;
import com.exceptions.starwars.dto.PersonajeInfoDTO;
import com.exceptions.starwars.dto.exceptionsDtos.ExceptionDTO;
import com.exceptions.starwars.util.enums.CrudOperation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonajeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final PersonajeInfoDTO personajeInfoDTOId1 = new PersonajeInfoDTO(
            1,
            "Luke Skywalker",
            172,
            77,
            "male",
            "Tatooine",
            "Human"
    );

    @Test
    public void findByNameHappyPath() throws Exception {
        // Arrange

        // paso 1 - request
        String url = "/findByName/{name}";
        String param = "Luke";
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body

        ArrayList<PersonajeInfoDTO> expected = new ArrayList<>();
        expected.add(personajeInfoDTOId1);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(statusExpected) // verifica el status
                //.andExpect(bodyExpected) // verifica el body
                //.andExpect(contentTypeExpected); // verifica el tipo
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    public void findByNameSadPathEmptyList() throws Exception {
        // Arrange

        // paso 1 - request
        String url = "/findByName/{name}";
        String param = "Monet";
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // paso 3 - construir el expected body

        ExceptionDTO expected = new ExceptionDTO(
                CrudOperation.READ,
                "La lista de personajes esta vacia"
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(statusExpected) // verifica el status
                //.andExpect(bodyExpected) // verifica el body
                //.andExpect(contentTypeExpected); // verifica el tipo
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }

    @Test
    public void addPersonajeHappyPath() throws Exception {
        // Arrange

        // paso 1 - request
        String url = "/add";

        PersonajeCompleteDTO personajeCompleteDTO = new PersonajeCompleteDTO(
                null,
                "Princesa Leia",
                155,
                60,
                "black",
                "white",
                "green",
                "1970/05/12",
                "female",
                "alderan",
                "human"
        );

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(
                        mapper.writeValueAsString(personajeCompleteDTO)
                )
                .contentType(MediaType.APPLICATION_JSON);

        // paso 2 - construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        // paso 3 - construir el expected body
        PersonajeCompleteDTO expected = new PersonajeCompleteDTO(
                3,
                "Princesa Leia",
                155,
                60,
                "black",
                "white",
                "green",
                "1970/05/12",
                "female",
                "alderan",
                "human"
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        // paso 4 - constuir el expected content type

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act & assert

        // ejecuta la request con una url provista
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(statusExpected) // verifica el status
                //.andExpect(bodyExpected) // verifica el body
                //.andExpect(contentTypeExpected); // verifica el tipo
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);

    }
}
