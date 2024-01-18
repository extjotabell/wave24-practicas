package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Long id);
}
