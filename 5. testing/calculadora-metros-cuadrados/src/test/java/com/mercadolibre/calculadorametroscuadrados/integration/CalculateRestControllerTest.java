package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private final String URL = "/calculate";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate() throws Exception {
        RoomDTO room1 = new RoomDTO();

        room1.setName("Room 1");
        room1.setLength(10);
        room1.setWidth(10);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setRooms(new ArrayList<>());
        houseDTO.getRooms().add(room1);
        houseDTO.setName("house");
        houseDTO.setAddress("Address");

        RequestBuilder request = MockMvcRequestBuilders.post(URL).content(
                objectMapper.writeValueAsString(houseDTO)
        ).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setSquareFeet(100);
        houseResponseDTO.setBiggest(room1);
        houseResponseDTO.setPrice(80000);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                objectMapper.writeValueAsString(houseResponseDTO)
        );

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);

    }
}