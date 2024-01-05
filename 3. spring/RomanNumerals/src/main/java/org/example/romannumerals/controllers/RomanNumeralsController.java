package org.example.romannumerals.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RomanNumeralsController {
    int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] stringNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    @GetMapping("/romannumerals/{number}")
    public String getRomanNumerals(@PathVariable int number) {
        String romanNumeral = "";
        int i = 0;
        while (number!=0) {
            while (number >= numbers[i]) {
                romanNumeral += stringNumerals[i];
                number -= numbers[i];
            }
            i++;
        }
        return romanNumeral;


    }
}
