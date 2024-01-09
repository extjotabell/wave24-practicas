package com.practica.edades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Edad {
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable Integer dia,
                           @PathVariable Integer mes,
                           @PathVariable Integer anio) {
        return Period.between( LocalDate.of(anio, mes, dia),LocalDate.now() ).getYears();
    }
}