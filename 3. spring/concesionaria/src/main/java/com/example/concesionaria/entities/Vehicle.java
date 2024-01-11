package com.example.concesionaria.entities;

import com.example.concesionaria.dtos.NewVehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    public static final Long idCounter = 0L;

    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private String doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> services;

    public Vehicle (NewVehicle newVehicle){
        this.brand = newVehicle.brand();
        this.model = newVehicle.model();
        this.manufacturingDate = newVehicle.manufacturingDate();
        this.numberOfKilometers = newVehicle.numberOfKilometers();
        this.doors = newVehicle.doors();
        this.price = newVehicle.price();
        this.currency = newVehicle.currency();
        this.countOfOwners = newVehicle.countOfOwners();
        this.services = newVehicle.services();
    }

    public Long getNewID() {
        if (idCounter == 0L) {
            return idCounter;
        }

        return idCounter + 1L;
    }

}
