package com.romanNumbers.romanNumbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberController {
    private String valueString[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private Integer valuesInteger[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    @GetMapping
    public String index() {
        return "Hola";
    }

    @GetMapping("/{number}")
    public String getRomanNumber(@PathVariable("number") Integer number) {
        return convertDecimalToRoman(number, "");
    }

    private String convertDecimalToRoman(Integer decimal, String roman) {
        if (decimal <= 0)
            return roman;

        for (int i = 0; i < valuesInteger.length; i++) {
            if (valuesInteger[i].intValue() == decimal || i == valuesInteger.length-1) {
                roman += valueString[i];
                decimal -= valuesInteger[i].intValue();
                break;
            } else if (valuesInteger[i].intValue() > decimal) {
                roman += valueString[i-1];
                decimal -= valuesInteger[i-1].intValue();
                break;
            }
        }

        return convertDecimalToRoman(decimal, roman);
    }
}