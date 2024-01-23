package org.starwars.ejerciciostarwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.starwars.ejerciciostarwars.dto.PersonajeDTO;
import org.starwars.ejerciciostarwars.dto.exceptionsDtos.ExceptionDTO;
import org.starwars.ejerciciostarwars.util.enums.CrudOperation;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonajeControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

//    public PersonajeControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
//        this.mockMvc = mockMvc;
//        this.mapper = mapper;
//    }

    private final PersonajeDTO personajeDTOId1 = new PersonajeDTO(
            "Luke Skywalker",
            172,
            77,
            "male",
            "Tatooine",
            "Human"
    );
    @Test
    public void findByNameHappyPath() throws Exception {

        // arrange
        String param = "Luke";
        String url = "/findByName/{name}";
        ArrayList<PersonajeDTO> expected = new ArrayList<>();
        expected.add(personajeDTOId1);

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

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
    public void findByNameSadPathEmptyList() throws Exception {

        // arrange
        String url = "/findByName/{name}";
        String param = "Monet";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        //
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //
        ExceptionDTO expected = new ExceptionDTO(
                CrudOperation.READ,
                404,
                "La lista de personajes está vacía");

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
    public void findByNameSadPathEmptyParam() throws Exception {

        // arrange
        String url = "/findByName/{name}";
        String param = " ";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        //
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        //
        ExceptionDTO expected = new ExceptionDTO(
                CrudOperation.READ,
                404,
                "El parametro nombre no puede estar vacío");

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
