package com.bootcampW22.EjercicioGlobal.unit.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepositoryTest {
    IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();

    final Vehicle vehicle1 = new Vehicle(1L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
    final Vehicle vehicle2 = new Vehicle(2L, "Buick", "LeSabre", "81962", "Green", 2005, "240", 6, "gasoline", "semi-automatic", 207.93, 125.94, 199.22);
    final Vehicle vehicle3 = new Vehicle(3L, "Mitsubishi", "Excel", "0904", "Green", 1987, "89", 5, "gas", "automatic", 39.18, 290.82, 121.17);
    final Vehicle vehicle4 = new Vehicle(4L, "Toyota", "4Runner", "496", "Puce", 1994, "127", 1, "gas", "automatic", 251.59, 121.06, 65.19);
    final List<Vehicle> vehiclesExpected = new ArrayList<>(List.of(vehicle1, vehicle2, vehicle3, vehicle4));

    @Test
    @DisplayName("find all size happy path")
    public void findAllHappyPathSizeTest() {
        // Arrange
        Integer sizeExpected = vehiclesExpected.size();
        // Act
        List<Vehicle> vehiclesResult = vehicleRepository.findAll();
        // Assets
        Assertions.assertEquals(sizeExpected, vehiclesResult.size());
    }

    @Test
    @DisplayName("find all happy path")
    public void findAllHappyPathTest() {
        // Arrange
        // Act
        List<Vehicle> vehiclesResult = vehicleRepository.findAll();

        // Assets
        Assertions.assertEquals(this.vehiclesExpected, vehiclesResult);
    }

    @Test
    @DisplayName("find by id happy path")
    public void findByIdHappyPathTest() {
        // Arrange
        Long id = 1L;
        // Act
        Optional<Vehicle> vehicleResult = vehicleRepository.findById(id);
        // Assets
        Assertions.assertEquals(Optional.of(vehicle1), vehicleResult);
    }

    @Test
    @DisplayName("find by id not found")
    public void findByIdNotFoundTest() {
        // Arrange
        Long id = 5L;
        // Act
        Optional<Vehicle> vehicleResult = vehicleRepository.findById(id);
        // Assets
        Assertions.assertEquals(Optional.empty(), vehicleResult);
    }

    @Test
    @DisplayName("findByDimensions happy path")
    public void findByDimensionsHappyPathTest() {
        // Arrange
        Double minLength = 10.0;
        Double maxLength = 300.0;
        Double minWidth = 10.0;
        Double maxWidth = 300.0;
        // Act
        List<Vehicle> vehiclesResult = vehicleRepository.findByDimensions(minLength, maxLength, minWidth, maxWidth);
        // Assets
        Assertions.assertEquals(vehiclesExpected, vehiclesResult);
    }

    @Test
    @DisplayName("findByDimensions not found")
    public void findByDimensionsNotFoundTest() {
        // Arrange
        Double minLength = 1.0;
        Double maxLength = 30.0;
        Double minWidth = 10.0;
        Double maxWidth = 30.0;
        // Act
        List<Vehicle> vehiclesResult = vehicleRepository.findByDimensions(minLength, maxLength, minWidth, maxWidth);
        // Assets
        Assertions.assertEquals(new ArrayList<>(), vehiclesResult);
    }

    @Test
    @DisplayName("update vehicle happy path")
    public void updateVehicleHappyPathTest() {
        // Arrange
        Vehicle vehicleUpdate = new Vehicle(1L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8);
        // Act
        Vehicle vehicleResult = vehicleRepository.update(vehicleUpdate);
        // Assets
        Assertions.assertEquals(vehicleUpdate, vehicleResult);
    }

    @Test
    @DisplayName("bulk create happy path")
    public void bulkCreateHappyPathTest() {
        // Arrange
        Vehicle vehicleTestIn = vehicle1;
        vehicleTestIn.setId(100L);
        Vehicle vehicleTestIn2 = vehicle2;
        vehicleTestIn2.setId(101L);
        List<Vehicle> vehicles = new ArrayList<>(List.of(vehicleTestIn, vehicleTestIn2));
        // Act
        List<Vehicle> vehiclesResult = vehicleRepository.bulkCreate(vehicles);
        // Assets
        Assertions.assertEquals(vehicles, vehiclesResult);
    }

}