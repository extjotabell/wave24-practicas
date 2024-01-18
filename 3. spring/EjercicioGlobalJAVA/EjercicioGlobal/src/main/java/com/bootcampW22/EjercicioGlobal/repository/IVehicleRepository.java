package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.ArrayList;

public interface IVehicleRepository extends ICrudRepository<Vehicle>{
    ArrayList<Vehicle> findAll();
    ArrayList<Vehicle> findByName(String name);
}
