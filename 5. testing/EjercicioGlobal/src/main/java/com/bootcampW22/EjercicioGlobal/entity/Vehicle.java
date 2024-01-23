package com.bootcampW22.EjercicioGlobal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Vehicle {
    private Integer id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private Integer year;
    private String max_speed;
    private Integer passengers;
    private String fuel_type;
    private String transmission;
    private Double length;
    private Double width;
    private Double weight;
}
