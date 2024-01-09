package com.numerosromanos.numeros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numerosromanos/{numeroAConvertir}")
public class NumerosRomanosController {
    /*
    *   En este contexto se requiere desarrollar una API para convertir un número decimal a
    *   un número romano.
    */

    //Metodo para convertir un numero decimal a romano
    public int romanoADecimal(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    //Controlador
    @GetMapping
    public String convertirRomanoADecimal(@PathVariable String numeroAConvertir) {
        int resultado = 0;

        for (int i = 0; i < numeroAConvertir.length(); i++) {

            //Obtener el char en la posicion actual i
            int s1 = romanoADecimal(numeroAConvertir.charAt(i));

            //Si i + 1 es menor que el tamaño de la cadena.
            if (i + 1 < numeroAConvertir.length()) {
                //Obtener el numero siguiente en la posicion i + 1
                int s2 = romanoADecimal(numeroAConvertir.charAt(i + 1));

                //Si s1 es mayor a s2 simplemente se suma a resultado.
                if (s1 >= s2) {
                    resultado = resultado + s1;
                }
                //Pero si es al reves, es un caso como IV, IX, XL, XC, CD, CM, se resta s1 de s2 y se suma a resultado.
                else {
                    resultado = resultado + s2 - s1;
                    i++; //Incrementa uno porque proceso dos numeros juntos.
                }

            }
            //  Si i + 1 es mayor que el tamaño de la cadena,
            //  simplemente se suma el caracter actual al resultado, ya que es el final.
            else {
                resultado = resultado + s1;
                i++;
            }
        }
        return "El resultado de la conversion de: " +numeroAConvertir+" es: " + resultado;
    }

}
