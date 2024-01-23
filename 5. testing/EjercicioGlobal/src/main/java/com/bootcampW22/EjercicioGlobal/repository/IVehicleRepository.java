package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle findById(Integer id);
    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> findByColorAndYear(String color, Integer year);
    Vehicle updateSpeed(Integer id, String speed);
    List<Vehicle> findByBrandAndYearsRange(String brand, Integer startYear, Integer endYear);
    Double calculateAverageSpeedByBrand(String brand);
    OptionalDouble calculateAveragePassangersByBrand(String brand);
}
