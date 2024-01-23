package com.bootcampW22.EjercicioGlobal.dto;

public record VehicleWithoutIdDto(
        String brand,
        String model,
        String registration,
        String color,
        Integer year,
        String max_speed,
        Integer passengers,
        String fuel_type,
        String transmission,
        Double length,
        Double width,
        Double weight
) {
}
