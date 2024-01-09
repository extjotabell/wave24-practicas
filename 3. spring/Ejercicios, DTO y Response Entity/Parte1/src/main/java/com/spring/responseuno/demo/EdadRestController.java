package com.spring.responseuno.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadRestController
{

    @GetMapping("/{dia}/{mes}/{anio}")
    public int devolverEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio){

        LocalDate param = LocalDate.of(anio,mes,dia);
        LocalDate hoy = LocalDate.now();

        Period p = Period.between(param,hoy);
        return p.getYears();

    }

}
