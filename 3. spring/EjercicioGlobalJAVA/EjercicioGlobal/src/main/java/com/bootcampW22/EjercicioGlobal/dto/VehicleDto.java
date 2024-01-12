package com.bootcampW22.EjercicioGlobal.dto;

public record VehicleDto(
    Long id,
    String brand,
    String model,
    String registration,
    String color,
    Integer year,
    Double max_speed,
    Integer passengers,
    String fuel_type,
    String transmission,
    Double length,
    Double width,
    Double weight
    ){
}
