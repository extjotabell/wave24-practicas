package org.example.ageapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

@RestController
public class AgeController {

    @GetMapping("/{day}/{month}/{year}/")
    public int calculateAge(@PathVariable("day") int day, @PathVariable("month") int month, @PathVariable("year") int year){
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(year, month, day);
        Period age = Period.between(date, now);
        return age.getYears();
    }
}
