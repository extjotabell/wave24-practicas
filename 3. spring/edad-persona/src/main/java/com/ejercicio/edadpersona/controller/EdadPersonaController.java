package com.ejercicio.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController()
public class EdadPersonaController {

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String obtenerEdad(@PathVariable int dia,
                              @PathVariable int mes,
                              @PathVariable int anio){

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return "Tu edad es: " + periodo.getYears() + " años";

    }

}
