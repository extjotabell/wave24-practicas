package com.Characters.character.integration;

import com.Characters.character.dto.PersonajeCompleteDTO;
import com.Characters.character.dto.PersonajeInfoDTO;
import com.Characters.character.dto.exceptions.ExceptionDTO;
import com.Characters.character.util.enums.CrudOperation;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@SpringBootTest
@AutoConfigureMockMvc
//En un Test de Integración , siempre validar : StatusCode, Body, y contentType Json.
//Si no se validan estos 3 puntos, se considera que el test de integración no esta completo.
public class PersonajeControllerTest {

    //creamos el objeto mockMVC y lo inyectamos con @Autowired
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
    public void findByNameTestHappyPath() throws Exception {
        //Arrange
        String param = "Luke";
        //paso 1 - Construir request
        RequestBuilder request = MockMvcRequestBuilders.get("/findByName/{name}", param);
        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //paso 3 - Construir bodyExpected
        ArrayList<PersonajeInfoDTO> expected = new ArrayList<>();
        expected.add(personajeInfoDTOId1);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected));
        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //ActAndAssert
        //ejecutamos la peticion y comparamos el resultado con el esperado
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                        //.andExpect(statusExpected) //comparamos el status
                        //.andExpect(bodyExpected) //comparamos el body
                        //.andExpect(contentTypeExpected); //comparamos el contentType
                    .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
    @Test
    public void findByNameSadPathEmptyList() throws Exception {
        //Arrange
        String param = "Monet";

        //paso 1 - Construir request
        RequestBuilder request = MockMvcRequestBuilders.get("/findByName/{name}", param);

        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //paso 3 - Construir bodyExpected
        ExceptionDTO expected = new ExceptionDTO(
                CrudOperation.READ,
                "La lista de personajes esta vacia"
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected));

        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //ActAndAssert
        //ejecutamos la peticion y comparamos el resultado con el esperado
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(statusExpected) //comparamos el status
                //.andExpect(bodyExpected) //comparamos el body
                //.andExpect(contentTypeExpected); //comparamos el contentType
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
    @Test
    public void addPersonajeHappyPath() throws Exception {
        //Arrange

        //paso 1 - Construir request
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
        RequestBuilder request = MockMvcRequestBuilders.post("/add")
                .content(mapper.writeValueAsString(personajeCompleteDTO))
                .contentType(MediaType.APPLICATION_JSON);

        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //paso 3 - Construir bodyExpected
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

        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Act&Assert
        //ejecutamos la peticion y comparamos el resultado con el esperado
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(statusExpected) //comparamos el status
                //.andExpect(bodyExpected) //comparamos el body
                //.andExpect(contentTypeExpected); //comparamos el contentType
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
}
