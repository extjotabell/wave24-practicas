package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("calculate (service): should return a HouseDTO if calculated")
    public void calculate(){
        //Arrange
        RoomDTO roomDTO1 = new RoomDTO("room1", 4, 3);
        RoomDTO roomDTO2 = new RoomDTO("room2", 5, 6);
        List<RoomDTO> roomDTOList = new ArrayList();
        roomDTOList.add(roomDTO1);
        roomDTOList.add(roomDTO2);
        HouseDTO house = new HouseDTO("name1", "direccion1", roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO(house);

        //Act
        var result = calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(expected, result);
    }
}
