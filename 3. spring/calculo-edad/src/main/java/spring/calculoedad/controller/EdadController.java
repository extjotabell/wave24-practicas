package spring.calculoedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("{day}/{month}/{year}")
    public int index(@PathVariable int day, @PathVariable int month, @PathVariable int year)
    {
        return Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
    }
}
