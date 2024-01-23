package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    private final List<RoomDTO> ROOMS = List.of(
            new RoomDTO("principal", 50, 50),
            new RoomDTO("secondary", 30, 30)
    );

    private final HouseDTO HOUSE = new HouseDTO("Kame-house", "Hawái", ROOMS);

    @Test
    public void calculateTest(){

        // Arrange
        HouseResponseDTO expected = new HouseResponseDTO(HOUSE);
        expected.setSquareFeet(3400);
        expected.setPrice(2720000);
        expected.setBiggest(ROOMS.get(0));

        // Act
//        Mockito.when(calculateService.calculate(HOUSE)).thenReturn(expected);
        HouseResponseDTO result = calculateRestController.calculate(HOUSE);


        // Assert
        Assertions.assertEquals(expected, result, "The result is incorrect");
    }
}
