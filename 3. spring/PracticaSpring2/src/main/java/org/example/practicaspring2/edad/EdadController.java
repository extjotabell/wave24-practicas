package org.example.practicaspring2.edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class EdadController {

    @GetMapping("{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        LocalDate fechaDeHoy = LocalDate.now();

        LocalDate diaDeNacimiento = LocalDate.of(anio, mes, dia);

        Period periodo = Period.between(diaDeNacimiento, fechaDeHoy);

        return periodo.getYears();
    }
}
