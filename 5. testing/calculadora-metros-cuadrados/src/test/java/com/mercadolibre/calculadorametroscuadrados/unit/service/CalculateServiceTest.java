package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTest {

    private CalculateService calculateService = new CalculateService();

    private final List<RoomDTO> ROOMS = List.of(
            new RoomDTO("principal", 50, 50),
            new RoomDTO("secondary", 30, 30)
    );

    private final HouseDTO HOUSE = new HouseDTO("Kame-house", "Hawái", ROOMS);

    @Test
    @DisplayName("Test that calculate method return the correct result")
    public void calculatePrice() {

        // Arrange
        Integer expected = 2720000;

        // Act
        HouseResponseDTO result = calculateService.calculate(HOUSE);

        // Assert
        Assertions.assertEquals(expected, result.getPrice(), "The result is incorrect");
    }

    @Test
    @DisplayName("Test that calculate method return the correct result")
    public void calculateBiggestRoom() {

        // Arrange
        RoomDTO expected = ROOMS.get(0);

        // Act
        HouseResponseDTO result = calculateService.calculate(HOUSE);

        // Assert
        Assertions.assertEquals(expected, result.getBiggest(), "The calculate of biggest room is incorrect");
    }

    @Test
    @DisplayName("Test that calculate the square feet of the house")
    public void calculateSquareFeetTest() {

        // Arrange
        Integer expected = 3400;

        // Act
        HouseResponseDTO result = calculateService.calculate(HOUSE);

        // Assert
        Assertions.assertEquals(expected, result.getSquareFeet(), "The calculate of square feet is incorrect");

    }


}
