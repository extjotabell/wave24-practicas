package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService = new CalculateService();

    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    @DisplayName("calculate (controller): should return a HouseDTO if calculated")
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
        Mockito.lenient().when(calculateService.calculate(house)).thenReturn(expected);
        var result = calculateRestController.calculate(house);

        //Assert
        Assertions.assertEquals(expected, result);
    }

}
