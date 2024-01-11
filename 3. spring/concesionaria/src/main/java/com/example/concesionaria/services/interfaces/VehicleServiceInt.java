package com.example.concesionaria.services.interfaces;

import com.example.concesionaria.dtos.NewVehicle;
import com.example.concesionaria.dtos.VehicleDTO;
import com.example.concesionaria.exceptions.NotFoundException;

import java.util.List;

public interface VehicleServiceInt {

    NewVehicle save(NewVehicle newVehicle);

    List<VehicleDTO> findAll();

    List<VehicleDTO> findVehiclesByDate(String since, String to);

    List<VehicleDTO> findVehiclesByPrice(Double since, Double to);

    NewVehicle findVehicleById(Long id) throws NotFoundException;
}
