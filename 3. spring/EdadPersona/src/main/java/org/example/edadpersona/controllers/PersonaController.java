package org.example.edadpersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
public class PersonaController {
    @GetMapping("/{day}/{month}/{year}")
    public String getEdadPersona(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        int years = Period.between(dateOfBirth, currentDate).getYears();
        return "La edad de la persona es: " + years;
    }
}
