package com.example.concesionaria.dtos;

import com.example.concesionaria.entities.Service;

import java.time.LocalDate;
import java.util.List;

public record NewVehicle(
        Long id,
        String brand,
        String model,
        LocalDate manufacturingDate,
        Long numberOfKilometers,
        String doors,
        Double price,
        String currency,
        Integer countOfOwners,
        List<Service>services
) {
}
