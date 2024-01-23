package com.bootcampW22.EjercicioGlobal.integration.controller;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    final VehicleDto vehicle1 = new VehicleDto(1L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
    final VehicleDto vehicle2 = new VehicleDto(2L, "Buick", "LeSabre", "81962", "Green", 2005, "240", 6, "gasoline", "semi-automatic", 207.93, 125.94, 199.22);
    final VehicleDto vehicle3 = new VehicleDto(3L, "Mitsubishi", "Excel", "0904", "Green", 1987, "89", 5, "gas", "automatic", 39.18, 290.82, 121.17);
    final VehicleDto vehicle4 = new VehicleDto(4L, "Toyota", "4Runner", "496", "Puce", 1994, "127", 1, "gas", "automatic", 251.59, 121.06, 65.19);


    @Test
    @DisplayName("Should return a list of vehicles")
    public void getVehiclesHappyPath() throws Exception {
        // Arrange
        String templateUri = "/vehicles";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);
        List<VehicleDto> expectedList = new ArrayList<>(List.of(vehicle1, vehicle2, vehicle3, vehicle4));
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expectedList)
        );


        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("Should return a list of vehicles by dimensions")
    public void getVehiclesByDimensionsHappyPath() throws Exception {
        // Arrange
        String templateUri = "/vehicles/dimensions?length=10-300&width=10-300";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);
        List<VehicleDto> expectedList = new ArrayList<>(List.of(vehicle1, vehicle2, vehicle3, vehicle4));
        ResultMatcher headerExpected = MockMvcResultMatchers.header().string("Content-Type", "application/json");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expectedList)
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(headerExpected)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("Should return a list empty of vehicles by dimensions")
    public void getVehiclesByDimensionsEmptyList() throws Exception {
        // Arrange
        String templateUri = "/vehicles/dimensions?length=1-2&width=1-2";
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        RequestBuilder request = MockMvcRequestBuilders.get(templateUri);
        ResultMatcher headerExpected = MockMvcResultMatchers.header().string("Content-Type", "application/json");
        ExceptionDto exceptionDto = new ExceptionDto("No Existen Vehiculos bajo los filtros porporcionados");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(exceptionDto)
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(headerExpected)
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("update fuel vehicle happy path")
    public void updateFuelVehicleHappyPath() throws Exception {
        // Arrange
        String templateUri = "/vehicles/1/update_fuel";
        VehicleDto vehicleDtoToUpdated =
                new VehicleDto(
                        1L,
                        "Pontiac",
                        "Fiero",
                        "6603",
                        "Mauv",
                        1986,
                        "85",
                        2,
                        "diesel",
                        "semi-automatic",
                        105.43,
                        280.28,
                        288.8
                );
        RequestBuilder request = MockMvcRequestBuilders.put(templateUri)
                .content(mapper.writeValueAsString(vehicleDtoToUpdated))
                .contentType("application/json");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(vehicleDtoToUpdated)
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("update fuel vehicle not found")
    public void updateFuelVehicleNotFound() throws Exception {
        // Arrange
        String templateUri = "/vehicles/100/update_fuel";
        VehicleDto vehicleDtoToUpdated =
                new VehicleDto(
                        100L,
                        "Pontiac",
                        "Fiero",
                        "6603",
                        "Mauv",
                        1986,
                        "85",
                        2,
                        "diesel",
                        "semi-automatic",
                        105.43,
                        280.28,
                        288.8
                );
        RequestBuilder request = MockMvcRequestBuilders.put(templateUri)
                .content(mapper.writeValueAsString(vehicleDtoToUpdated))
                .contentType("application/json");
        ExceptionDto exceptionDto = new ExceptionDto("Vehiculo no encontrado");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher headerExpected = MockMvcResultMatchers.header().string("Content-Type", "application/json");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(exceptionDto)
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(headerExpected)
                .andExpect(bodyExpected);
    }

    @Test
    @DisplayName("update fuel vehicle bad request fuel type invalid")
    public void updateFuelVehicleFuelTypeInvalid() throws Exception {
        // Arrange
        String templateUri = "/vehicles/1/update_fuel";
        VehicleDto vehicleDtoToUpdated =
                new VehicleDto(
                        1L,
                        "Pontiac",
                        "Fiero",
                        "6603",
                        "Mauv",
                        1986,
                        "85",
                        2,
                        "gasolina",
                        "semi-automatic",
                        105.43,
                        280.28,
                        288.8
                );
        RequestBuilder request = MockMvcRequestBuilders.put(templateUri)
                .content(mapper.writeValueAsString(vehicleDtoToUpdated))
                .contentType("application/json");
        ExceptionDto exceptionDto = new ExceptionDto("El combustible proporcinado no es valido");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher headerExpected = MockMvcResultMatchers.header().string("Content-Type", "application/json");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(exceptionDto)
        );

        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(headerExpected)
                .andExpect(bodyExpected);
    }
}
