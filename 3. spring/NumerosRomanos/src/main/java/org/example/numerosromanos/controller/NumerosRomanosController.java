package org.example.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/romano/{numero}")
    public String getRomano(@PathVariable Integer numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Input should be between 1 and 3999");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (numero > 0) {
            int divisor = numero / values[i];
            numero %= values[i];
            result.append(symbols[i].repeat(divisor));
            i++;
        }

        return result.toString();
    }
}
