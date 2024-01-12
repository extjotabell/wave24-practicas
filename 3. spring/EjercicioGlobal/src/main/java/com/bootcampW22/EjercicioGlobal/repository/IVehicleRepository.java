package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Vehicle> bulkCreate(List<Vehicle> vehicles);

    Optional<Vehicle> findById(Long id);
    List<Vehicle> findByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth);
    Vehicle update(Vehicle vehicle);
}
