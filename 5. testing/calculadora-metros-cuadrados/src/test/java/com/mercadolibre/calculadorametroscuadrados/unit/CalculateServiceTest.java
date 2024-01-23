package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculateServiceTest {

    private final CalculateService calculateService = new CalculateService();

    private final HouseDTO house = new HouseDTO();

    private HouseResponseDTO expected;

    private final RoomDTO room1 = new RoomDTO();

    private final RoomDTO room2 = new RoomDTO();

    @BeforeEach
    void setUp() {
        room1.setName("Room 1");
        room1.setLength(10);
        room1.setWidth(10);
        room2.setName("Room 2");
        room2.setLength(20);
        room2.setWidth(20);
        house.setName("House");
        house.setAddress("Address");
        house.setRooms(List.of(room1, room2));
        expected = new HouseResponseDTO(house);
        expected.setSquareFeet(500);
        expected.setPrice(400000);
        expected.setBiggest(room2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate() {
        HouseResponseDTO response = calculateService.calculate(house);
        Assertions.assertEquals(expected.getPrice(), response.getPrice());
        Assertions.assertEquals(expected.getSquareFeet(),response.getSquareFeet());
        Assertions.assertEquals(expected.getBiggest(),response.getBiggest());
    }

    @Test
    void calculateRoomSquareFeet() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HouseResponseDTO response = new HouseResponseDTO(house);
        Method method = calculateService.getClass().getDeclaredMethod("calculateRoomSquareFeet", HouseDTO.class, HouseResponseDTO.class);
        method.setAccessible(true);
        method.invoke(calculateService, house, response);
        Assertions.assertEquals(expected.getSquareFeet(),response.getSquareFeet());
        Assertions.assertEquals(expected.getBiggest(),response.getBiggest());
    }

    @Test
    void calculateRoomSquareFeetException() {
        Assertions.assertThrows(InvocationTargetException.class, () -> {
            Method method = calculateService.getClass().getDeclaredMethod("calculateRoomSquareFeet", HouseDTO.class, HouseResponseDTO.class);
            method.setAccessible(true);
            method.invoke(calculateService, null, null);
        });
    }

    @Test
    void calculatePrice() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = calculateService.getClass().getDeclaredMethod("calculatePrice", Integer.class);
        method.setAccessible(true);
        int result = (int) method.invoke(calculateService, 100);
        assertEquals(80000, result);
    }
}