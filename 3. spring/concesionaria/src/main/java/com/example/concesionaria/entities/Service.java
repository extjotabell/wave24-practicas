package com.example.concesionaria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private Long kilometers;
    private String description;
}
