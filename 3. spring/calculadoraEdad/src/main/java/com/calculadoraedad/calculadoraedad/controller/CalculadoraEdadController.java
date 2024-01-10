package com.calculadoraedad.calculadoraedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraEdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calculoEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate nacimiento = LocalDate.of(anio,mes,dia);
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(nacimiento,hoy);

        return periodo.getYears();
    }
}
