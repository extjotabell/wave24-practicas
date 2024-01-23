package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Test register student successfully")
    void registerStudentSuccessfullyTest() throws Exception {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House 1");
        houseDTO.setAddress("Address 1");
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Room 1");
        room1.setWidth(10);
        room1.setLength(10);
        rooms.add(room1);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Room 2");
        room2.setWidth(24);
        room2.setLength(52);
        rooms.add(room2);
        RoomDTO room3 = new RoomDTO();
        room3.setName("Room 3");
        room3.setWidth(24);
        room3.setLength(12);
        rooms.add(room3);
        houseDTO.setRooms(rooms);

        HouseResponseDTO expectedResponse = new HouseResponseDTO(houseDTO);
        expectedResponse.setBiggest(room2);
        expectedResponse.setPrice(1308800);
        expectedResponse.setSquareFeet(1636);

        MockHttpServletRequestBuilder request = post("/calculate")
                .content(mapper.writeValueAsString(houseDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedResponse)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

}
