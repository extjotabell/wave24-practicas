package com.bootcampW22.EjercicioGlobal.unit.service;

import com.bootcampW22.EjercicioGlobal.dto.CreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @InjectMocks
    VehicleServiceImpl vehicleService;
    @Mock
    VehicleRepositoryImpl vehicleRepository;

    final List<VehicleDto> vehiclesIn = new ArrayList<>();
    final VehicleDto vehicle1 = new VehicleDto(
            11L,
            "Pontiac",
            "Fiero",
            "6603",
            "Mauv",
            1986,
            "85",
            2,
            "gasoline",
            "semi-automatic",
            105.43,
            280.28,
            288.8
    );

    @Test
    @DisplayName("Should bulk create a vehicles")
    public void shouldBulkCreateVehicles(){
        // Arrange
        vehiclesIn.add(vehicle1);
        Vehicle vehicleIn =  new Vehicle(11L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        List<Vehicle> vehicles = new ArrayList<>(List.of(vehicleIn));
        List<CreateVehicleDTO> expected = new ArrayList<>(List.of(new CreateVehicleDTO(11L)));
        // Act
        // Mockito.anyString o anyLong es para darle cualquier valor a un parametro
        Mockito.when(vehicleRepository.findById(11L)).thenReturn(Optional.empty());
        Mockito.when(vehicleRepository.bulkCreate(vehicles)).thenReturn(vehicles);
        List<CreateVehicleDTO> result = vehicleService.createVehiclesBatch(vehiclesIn);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should throw ConflictException when bulk create a vehicles")
    public void shouldThrowConflictExceptionWhenBulkCreateVehicles(){
        // Arrange
        vehiclesIn.add(vehicle1);
        Vehicle vehicleIn =  new Vehicle(11L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        List<Vehicle> vehicles = new ArrayList<>(List.of(vehicleIn));
        // Act
        // Mockito.anyString o anyLong es para darle cualquier valor a un parametro
        Mockito.when(vehicleRepository.findById(11L)).thenReturn(Optional.of(vehicleIn));
        // Assert
        Assertions.assertThrows(ConflictException.class, () -> vehicleService.createVehiclesBatch(vehiclesIn));
    }

    @Test
    @DisplayName("searchAllVehicles should return a list of vehicles")
    public void searchAllVehiclesShouldReturnAListOfVehicles(){
        // Arrange
        Vehicle vehicleIn =  new Vehicle(11L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        List<Vehicle> vehicles = new ArrayList<>(List.of(vehicleIn));
        List<VehicleDto> expected = new ArrayList<>(List.of(vehicle1));
        // Act
        Mockito.when(vehicleRepository.findAll()).thenReturn(vehicles);
        List<VehicleDto> result = vehicleService.searchAllVehicles();
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("searchAllVehicles should throw NotFoundException when list of vehicles is empty")
    public void searchAllVehiclesShouldThrowNotFoundExceptionWhenListOfVehiclesIsEmpty(){
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        // Act
        Mockito.when(vehicleRepository.findAll()).thenReturn(vehicles);
        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> vehicleService.searchAllVehicles());
    }

    @Test
    @DisplayName("findByDimensions should return a list of vehicles")
    public void findByDimensionsShouldReturnAListOfVehicles(){
        // Arrange
        Vehicle vehicleIn =  new Vehicle(11L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        List<Vehicle> vehicles = new ArrayList<>(List.of(vehicleIn));
        List<VehicleDto> expected = new ArrayList<>(List.of(vehicle1));
        // Act
        Mockito.when(vehicleRepository.findByDimensions(10D, 200D, 10D, 200D)).thenReturn(vehicles);
        List<VehicleDto> result = vehicleService.findByDimensions(10D, 200D, 10D, 200D);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("findByDimensions should throw NotFoundException when list of vehicles is empty")
    public void findByDimensionsShouldThrowNotFoundExceptionWhenListOfVehiclesIsEmpty(){
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        // Act
        Mockito.when(vehicleRepository.findByDimensions(10D, 200D, 10D, 200D)).thenReturn(vehicles);
        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> vehicleService.findByDimensions(10D, 200D, 10D, 200D));
    }

    @Test
    @DisplayName("updateFuel should update fuel of a vehicle")
public void updateFuelShouldUpdateFuelOfAVehicle(){
        // Arrange
        Vehicle vehicleIn =  new Vehicle(11L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        VehicleDto expected = new VehicleDto(
                11L,
                "Pontiac",
                "Fiero",
                "6603",
                "Mauv",
                1986,
                "85",
                2,
                "gasoline",
                "semi-automatic",
                105.43,
                280.28,
                288.8
        );
        VehicleDto vehicleDtoIn = new VehicleDto(
                11L,
                "Pontiac",
                "Fiero",
                "6603",
                "Mauv",
                1986,
                "85",
                2,
                "gasoline",
                "semi-automatic",
                105.43,
                280.28,
                288.8
        );
        // Act
        Mockito.when(vehicleRepository.findById(11L)).thenReturn(Optional.of(vehicleIn));
        Mockito.when(vehicleRepository.update(vehicleIn)).thenReturn(vehicleIn);
        VehicleDto result = vehicleService.updateFuel(vehicleDtoIn);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("updateFuel should throw NotFoundException when vehicle is not found")
    public void updateFuelShouldThrowNotFoundExceptionWhenVehicleIsNotFound(){
        // Arrange
        VehicleDto vehicleDtoIn = new VehicleDto(
                11L,
                "Pontiac",
                "Fiero",
                "6603",
                "Mauv",
                1986,
                "85",
                2,
                "gasoline",
                "semi-automatic",
                105.43,
                280.28,
                288.8
        );
        // Act
        Mockito.when(vehicleRepository.findById(11L)).thenReturn(Optional.empty());
        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> vehicleService.updateFuel(vehicleDtoIn));
    }

    @Test
    @DisplayName("updateFuel should throw BadRequestException when fuel is not valid")
    public void updateFuelShouldThrowBadRequestExceptionWhenFuelIsNotValid(){
        // Arrange
        Vehicle vehicleIn =  new Vehicle(11L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        VehicleDto vehicleDtoIn = new VehicleDto(
                11L,
                "Pontiac",
                "Fiero",
                "6603",
                "Mauv",
                1986,
                "85",
                2,
                "gasogaso",
                "semi-automatic",
                105.43,
                280.28,
                288.8
        );
        // Act
        Mockito.when(vehicleRepository.findById(11L)).thenReturn(Optional.of(vehicleIn));
        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> vehicleService.updateFuel(vehicleDtoIn));
    }
}
