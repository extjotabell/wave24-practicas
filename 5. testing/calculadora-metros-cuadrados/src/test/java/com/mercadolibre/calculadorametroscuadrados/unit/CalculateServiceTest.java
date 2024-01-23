package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CalculateServiceTest {
    String testingHouseName = "test";
    String testingHouseAddress = "St. test";
    RoomDTO testingRoom1 = new RoomDTO(
            "room1",
            20,
            30
    );

    RoomDTO testingRoom2 = new RoomDTO(
            "room2",
            10,
            40
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

    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("Calculate Service: Calculate valid value.")
    void calculateValidValue() {
        // Arrange
        Integer expectedSquareFeet = 1000;
        RoomDTO expectedBiggestRoom = testingRoom1;
        Integer expectedPrice = 800000;

        // Act
        var result = calculateService.calculate(testingHouse);

        // Assert
        Assertions.assertEquals(expectedSquareFeet, result.getSquareFeet());
        Assertions.assertEquals(expectedBiggestRoom, result.getBiggest());
        Assertions.assertEquals(expectedPrice, result.getPrice());
    }
}
