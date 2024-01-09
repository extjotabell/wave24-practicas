package org.agecalculator.agecalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeCalculator {

    @GetMapping("/{day}/{month}/{year}")
    @ResponseBody
    public String calculate(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        var today = LocalDate.now();
        var intDay = Integer.parseInt(day);
        var intMonth = Integer.parseInt(month);
        var intYear = Integer.parseInt(year);

        if (intYear > today.getYear())
            return "Invalid year: Year must not be greater than actual year!";
        else if (intMonth > 12 || (intYear == today.getYear() && intMonth > today.getMonthValue()))
            return "Invalid month: Month must be between 1 and 12 or not be greater than actual date month!";
        else if (intDay > 31 || (intYear == today.getYear() && intMonth == today.getMonthValue() && intDay > today.getDayOfMonth()))
            return "Invalid day: Day must be between 1 and 31 or not be greater than actual date day!";

        var age = Period.between(LocalDate.of(intYear, intMonth, intDay), today).getYears();

        return String.format("Your age is %d", age);
    }
}
