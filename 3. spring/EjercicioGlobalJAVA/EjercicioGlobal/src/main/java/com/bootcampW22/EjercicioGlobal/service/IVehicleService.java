package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto create(Vehicle vehicle);
    List<VehicleDto> searchByColorAndYear(String color, Integer year);
    List<VehicleDto> searchByBrandAndYear(String brand, Integer start_year, Integer end_year);
    Double getAverageSpeedByBrand(String brand);
    List<VehicleDto> createBatch(List<Vehicle> vehicles);
    VehicleDto updateSpeed(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
