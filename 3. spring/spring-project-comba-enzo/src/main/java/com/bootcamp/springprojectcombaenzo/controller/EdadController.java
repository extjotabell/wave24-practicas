package com.bootcamp.springprojectcombaenzo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/edad")
public class EdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return Period.between(LocalDate.of(anio, mes, dia), LocalDate.now()).getYears();
    }
}
