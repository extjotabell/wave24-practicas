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
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTestI {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final CharacterDTO characterDTO1 = new CharacterDTO(
            "Darth Vader",
            202,
            136,
            "none",
            "white",
            "yellow",
            "41.9BBY",
            "male",
            "Tatooine",
            "Human"
    );

    private final CharacterDTO characterDTO2 = new CharacterDTO(
            "Darth Maul",
            175,
            80,
            "none",
            "red",
            "yellow",
            "54BBY",
            "male",
            "Dathomir",
            "Zabrak"
    );

    @Test
    public void find() throws Exception {

        //Arrange
        String query = "Darth";
        String url = "/{query}";

        RequestBuilder request = MockMvcRequestBuilders.get(url, query);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(characterDTO1);
        expected.add(characterDTO2);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);

    }
}
