package com.example.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class Auto {
    private Integer id;
    private String brand;
    private String model;
    private Date manufactoringDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Map<String, String> services;
    private Integer  countOFOwners;


}
