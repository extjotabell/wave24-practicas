package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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
public class CalculateTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @InjectMocks
    CalculateRestController controller;

    /*private final HouseDTO houseDTO = new HouseDTO("casa", "calle",
            List.of(new RoomDTO("pieza", 10, 5)));

    private final HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
    */

    @Test
    public void calculate() throws Exception {
        //arrange
        HouseDTO param = new HouseDTO("casa", "calle",
                List.of(new RoomDTO("pieza", 10, 5)));
        RequestBuilder request = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(param));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        HouseResponseDTO expected = new HouseResponseDTO("casa", "calle",
                List.of(new RoomDTO("pieza", 10, 5)),
                        50, 40000, new RoomDTO("pieza", 10, 5));

        //HouseResponseDTO expected = new HouseResponseDTO(param);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

}