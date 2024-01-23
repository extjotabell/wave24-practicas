package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraMetrosCuadradosIntegrationTests {
    String testingHouseName = "test";
    String testingHouseAddress = "Av. test";
    RoomDTO testingRoom1 = new RoomDTO(
            "room1",
            5,
            7
    );

    RoomDTO testingRoom2 = new RoomDTO(
            "room2",
            10,
            14
    );
    List<RoomDTO> testingRooms = new ArrayList<>(){
        {
            add(testingRoom1);
            add(testingRoom2);
        }
    };
    HouseDTO testingHouse = new HouseDTO(
            testingHouseName,
            testingHouseAddress,
            testingRooms
    );

    MockMvc mock;
    ObjectMapper mapper;

    @Autowired
    public CalculadoraMetrosCuadradosIntegrationTests(MockMvc mock, ObjectMapper mapper){
        this.mock = mock;
        this.mapper = mapper;
    }

    @Test
    @DisplayName("Calculate Rest Controller: Testing House Price.")
    void testHousePrice() throws Exception {
        // Arrange
        Integer expectedHousePrice = 140000;

        // Act
        // Assert
        mock.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(testingHouse))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expectedHousePrice));
    }

    @Test
    @DisplayName("Calculate Rest Controller: Testing House Square Feet.")
    void testHouseSquareFeet() throws Exception {
        // Arrange
        Integer expectedHouseSquareFeet = 175;

        // Act
        // Assert
        mock.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(testingHouse))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.squareFeet").value(expectedHouseSquareFeet)
                );
    }

    @Test
    @DisplayName("Calculate Rest Controller: Testing House Biggest Room.")
    void testHouseBiggestRoom() throws Exception {
        // Arrange
        String expectedHouseBiggestRoom = "room2";

        // Act
        // Assert
        mock.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(testingHouse))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.biggest.name").value(expectedHouseBiggestRoom)
                );
    }
}