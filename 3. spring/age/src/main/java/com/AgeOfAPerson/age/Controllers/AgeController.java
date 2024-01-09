package com.AgeOfAPerson.age.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public String calculateAge(@PathVariable int day,
                               @PathVariable int month,
                               @PathVariable int year){
        return "La edad es de: "+ Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears() + " años" ;
    }

}
