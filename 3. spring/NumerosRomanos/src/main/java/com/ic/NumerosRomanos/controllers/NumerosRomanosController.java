package com.ic.NumerosRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/convertirARomano/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        StringBuilder resultado = new StringBuilder();
        int miles = numero / 1000;
        int centenas = (numero % 1000) / 100;
        int decenas = (numero % 100) / 10;
        int unidades = numero % 10;

        for (int i = 0; i < miles; i++) {
            resultado.append("M");
        }

        if (centenas == 9) {
            resultado.append("CM");
        } else if (centenas >= 5) {
            resultado.append("D");
            for (int i = 0; i < centenas - 5; i++) {
                resultado.append("C");
            }
        } else if (centenas == 4) {
            resultado.append("CD");
        } else {
            for (int i = 0; i < centenas; i++) {
                resultado.append("C");
            }
        }

        if (decenas == 9) {
            resultado.append("XC");
        } else if (decenas >= 5) {
            resultado.append("L");
            for (int i = 0; i < decenas - 5; i++) {
                resultado.append("X");
            }
        } else if (decenas == 4) {
            resultado.append("XL");
        } else {
            for (int i = 0; i < decenas; i++) {
                resultado.append("X");
            }
        }

        if (unidades == 9) {
            resultado.append("IX");
        } else if (unidades >= 5) {
            resultado.append("V");
            for (int i = 0; i < unidades - 5; i++) {
                resultado.append("I");
            }
        } else if (unidades == 4) {
            resultado.append("IV");
        } else {
            for (int i = 0; i < unidades; i++) {
                resultado.append("I");
            }
        }

        return resultado.toString();
    }


}
