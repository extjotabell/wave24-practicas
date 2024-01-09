package org.example.calcularedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@RestController
public class CalcularEdadRestController {

    @GetMapping("/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        return Period.between(birthDate, currentDate).getYears();
    }

}
