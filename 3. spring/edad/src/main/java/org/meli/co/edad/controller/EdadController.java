package org.meli.co.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String edad(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return "Tu edad es: " + periodo.getYears() + " años";
    }

}
