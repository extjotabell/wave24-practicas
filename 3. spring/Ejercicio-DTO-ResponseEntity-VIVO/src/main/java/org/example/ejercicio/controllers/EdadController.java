package org.example.ejercicio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadController {


    @GetMapping("/{dd}/{mm}/{yyyy}")
    public Integer calcularEdad(@PathVariable("dd") Integer dia, @PathVariable("mm") Integer mes, @PathVariable("yyyy") Integer anio) {

        LocalDate anioActual = LocalDate.now();
        LocalDate anioNacimiento = LocalDate.of(anio, mes, dia);
        int edad = anioActual.getYear() - anioNacimiento.getYear();
        if(anioNacimiento.getMonth().getValue() > anioActual.getMonth().getValue() && anioNacimiento.getDayOfMonth() > anioActual.getDayOfMonth()) {
            edad--;
        }
        return edad;
    }
}
