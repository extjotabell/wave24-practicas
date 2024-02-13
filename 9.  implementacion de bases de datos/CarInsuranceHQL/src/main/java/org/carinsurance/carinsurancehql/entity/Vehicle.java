package org.carinsurance.carinsurancehql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patent;
    private String brand;
    private String model;
    @Column(name = "fabrication_year")
    private String fabricationYear;
    @Column(name = "quantity_wheels")
    private Integer quantityWheels;

}
