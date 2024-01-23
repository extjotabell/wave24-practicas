package com.DecimalToRoman.decimal_to_roman.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertToRoman")
public class DecimalToRomanController {
    @GetMapping("/{number}")
    public ResponseEntity<String> toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] decimalNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < decimalNumbers.length; i++)
            for (;number >= decimalNumbers[i]; number -= decimalNumbers[i])
                romanNumber.append(romanNumbers[i]);

        return ResponseEntity.ok(romanNumber.toString());
    }
}
