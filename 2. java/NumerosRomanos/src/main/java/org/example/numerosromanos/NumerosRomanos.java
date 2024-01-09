package org.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController("/")
public class NumerosRomanos {

    @GetMapping("{numero}")
    public String convert(@PathVariable Integer numero){
        Map<Integer, String> ROMAN_NUMERALS = getIntegerStringMap();

        if (numero <= 0 || numero > 3999) {
            return "Número fuera de rango"; // Se limita el rango a números entre 1 y 3999
        }

        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> entry : ROMAN_NUMERALS.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();

            while (numero >= value) {
                roman.append(numeral);
                numero -= value;
            }
        }

        return roman.toString();
    }

    private static Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> ROMAN_NUMERALS = new LinkedHashMap<>();

        ROMAN_NUMERALS.put(1000, "M");
        ROMAN_NUMERALS.put(900, "CM");
        ROMAN_NUMERALS.put(500, "D");
        ROMAN_NUMERALS.put(400, "CD");
        ROMAN_NUMERALS.put(100, "C");
        ROMAN_NUMERALS.put(90, "XC");
        ROMAN_NUMERALS.put(50, "L");
        ROMAN_NUMERALS.put(40, "XL");
        ROMAN_NUMERALS.put(10, "X");
        ROMAN_NUMERALS.put(9, "IX");
        ROMAN_NUMERALS.put(5, "V");
        ROMAN_NUMERALS.put(4, "IV");
        ROMAN_NUMERALS.put(1, "I");
        return ROMAN_NUMERALS;
    }

}
    
