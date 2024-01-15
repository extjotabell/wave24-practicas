package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll(); //punto numero 1

    Optional<Vehicle> updateSpeed(Integer id, String speed);

    Optional<Vehicle> getVehicle(Integer id);
    Vehicle createVehicle(Vehicle vehicle); //punto 2

    List<Vehicle> filterbyColorYear(String color,  Integer year);

    List<Vehicle> filterbyBrandYear(String brand, Integer yearInit , Integer yearEnd);
    //
}
