package com.juan.guevara.ApiRomanos.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RomanosController {

    @GetMapping("/{number}")
public String convertiRomano(@PathVariable int number){
    return convertToRomanNumber(number);
}
    private String convertToRomanNumber(int number) {
        if (number <= 0 || number > 3999) {
            return "Número no válido para la conversión a romano.";
        }

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] decimalValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder result = new StringBuilder();

        int index = 12; // Índice máximo en los arreglos
        while (number > 0) {
            int div = number / decimalValues[index];
            number %= decimalValues[index];
            while (div-- > 0) {
                result.append(romanSymbols[index]);
            }
            index--;
        }

        return result.toString();
    }




}
