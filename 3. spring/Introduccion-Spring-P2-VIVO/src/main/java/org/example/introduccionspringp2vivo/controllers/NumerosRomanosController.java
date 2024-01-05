package org.example.introduccionspringp2vivo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cast")
public class NumerosRomanosController {

    @GetMapping("/{number}")
    public String convertirNumero(@PathVariable("number") Integer numero) {
        if (numero <= 0 || numero > 3999) {
            return "El número debe estar en el rango de 1 a 3999";
        }

        String[] simbolos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] valores = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder resultado = new StringBuilder();
        int indice = valores.length - 1;

        while (numero > 0) {
            int cociente = numero / valores[indice];
            numero %= valores[indice];

            resultado.append(simbolos[indice].repeat(cociente));

            indice--;
        }

        return resultado.toString();
    }
}
