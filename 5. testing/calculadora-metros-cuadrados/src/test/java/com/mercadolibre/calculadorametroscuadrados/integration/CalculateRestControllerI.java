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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerI {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void calculate() throws Exception {
        String url = "/calculate";
        RoomDTO roomDTO1 = new RoomDTO("room1", 4, 3);
        RoomDTO roomDTO2 = new RoomDTO("room2", 5, 6);
        List<RoomDTO> roomDTOList = new ArrayList();
        roomDTOList.add(roomDTO1);
        roomDTOList.add(roomDTO2);
        HouseDTO house = new HouseDTO("name1", "direccion1", roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO("name1", "direccion1", roomDTOList, 42, 33600, roomDTO2);

        RequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(house));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);

    }

}
