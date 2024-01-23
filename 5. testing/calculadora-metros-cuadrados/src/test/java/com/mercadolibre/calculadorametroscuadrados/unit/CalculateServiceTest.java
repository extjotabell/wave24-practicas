package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("Test calculate method")
    void calculateTest(){
        //Arrange
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
        //Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);
        //Assert
        assertEquals(expectedResponse, result, "The response is not the expected");
    }
}
