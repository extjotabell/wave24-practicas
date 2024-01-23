package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
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
public class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final List<RoomDTO> ROOMS = List.of(
            new RoomDTO("principal", 50, 50),
            new RoomDTO("secondary", 30, 30)
    );

    private final HouseDTO HOUSE = new HouseDTO("Kame-house", "Hawái", ROOMS);

    @Test
    public void calculateTest() throws Exception {

        // Arrange
        String url = "/calculate";
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(mapper.writeValueAsString(HOUSE))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        HouseResponseDTO expected = new HouseResponseDTO(HOUSE);
        expected.setSquareFeet(3400);
        expected.setPrice(2720000);
        expected.setBiggest(ROOMS.get(0));

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
