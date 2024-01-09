package com.edadpersona.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/edades")
public class EdadRestController {
    @GetMapping("/{day}/{month}/{year}")
    private int getEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        LocalDate date = LocalDate.of(year, month, day);
        Period period = Period.between(date, LocalDate.now());
        return period.getYears();

    }
}
