package com.spring.EdadPersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/calcularEdad")
public class EdadPersonaController {


    @GetMapping
    public String inicio() {
        return "Pagina principal calcular edad";
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

        //Fecha dada por la URL
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        Period peoriodo = Period.between(fecha, LocalDate.now());
        return peoriodo.getYears();

    }
}
