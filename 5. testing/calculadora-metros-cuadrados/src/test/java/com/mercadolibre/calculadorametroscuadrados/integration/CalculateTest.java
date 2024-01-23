package com.mercadolibre.calculadorametroscuadrados.integration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("calculate (service): should return a HouseDTO if calculated")
    public void calculate() throws Exception {
        HouseDTO houseDTO = new HouseDTO("casa", "calle13", List.of(new RoomDTO("sala", 10, 10)));
        RequestBuilder request = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(houseDTO));
        ResultMatcher status = MockMvcResultMatchers.status().isOk();
        HouseResponseDTO expected = new HouseResponseDTO("casa", "calle13",
                List.of(new RoomDTO("sala", 10, 10)),
                100, 80000, new RoomDTO("sala", 10, 10));
        ResultMatcher body = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected));
        ResultMatcher content = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(status, body, content);
    }
}
