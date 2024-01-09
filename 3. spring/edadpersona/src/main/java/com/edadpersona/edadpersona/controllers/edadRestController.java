package com.edadpersona.edadpersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
@RequestMapping("/edad")
public class edadRestController {

        @GetMapping("/{dia}/{mes}/{anio}")
        public String calcularEdad(@PathVariable String dia,@PathVariable String mes,@PathVariable String anio) {
            //Date fecha = new Date(Integer.valueOf(anio), Integer.valueOf(mes), Integer.valueOf(dia));
            Integer year = Integer.valueOf(anio);
            Integer month = Integer.valueOf(mes);
            Integer day = Integer.valueOf(dia);
            return Integer.toString(Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears());
        }

}
