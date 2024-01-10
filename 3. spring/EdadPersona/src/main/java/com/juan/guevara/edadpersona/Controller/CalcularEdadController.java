package com.juan.guevara.edadpersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalcularEdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return "La edad es: " + Period.between(LocalDate.of(anio, mes, dia), LocalDate.now()).getYears();
    }
}
