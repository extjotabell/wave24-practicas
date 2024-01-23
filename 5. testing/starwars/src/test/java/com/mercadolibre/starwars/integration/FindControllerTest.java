package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
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
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final CharacterDTO characterNamedLuke = new CharacterDTO(
            "Luke Skywalker",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human",
            172,
            77
    );

    @Test
    public void findByNameHappyPath() throws Exception {
        String url = "/{query}";
        String param = "Luke";
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ArrayList<CharacterDTO> expected = new ArrayList<>();
        expected.add(characterNamedLuke);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    public void findByNameSadPathEmptyList() throws Exception {
        String url = "/{query}";
        String param = "Monet";
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ArrayList<CharacterDTO> expected = new ArrayList<>();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected);

    }
    
}
