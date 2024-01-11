package com.spring.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/conversor")
public class ConversorController {

    public Map<String, Integer> mapa = new LinkedHashMap<>();

    @GetMapping
    public String inicio() {
        return "Conversor de decimal a romanos";
    }


    public ConversorController() {

        mapa.put("M", 1000);
        mapa.put("CM", 900);
        mapa.put("D", 500);
        mapa.put("CD", 400);
        mapa.put("C", 100);
        mapa.put("XC", 90);
        mapa.put("L", 50);
        mapa.put("XL", 40);
        mapa.put("X", 10);
        mapa.put("IX", 9);
        mapa.put("V", 5);
        mapa.put("IV", 4);
        mapa.put("I", 1);
    }

    @GetMapping("/{decimal}")
    public String conversor(@PathVariable Integer decimal) {
        if (decimal < 1 || decimal > 3999) {
            return "Valor invalido";
        }

        StringBuilder numeroEnRomano = new StringBuilder();
        int numero = decimal;

        while (numero > 0){
            // map.entrySet() devuelve las entradas como un conjunto de tipo Map.Entry
            for( Map.Entry<String, Integer> par : mapa.entrySet() ){
                if(numero >= par.getValue()){
                    numero = numero - par.getValue();
                    numeroEnRomano.append(par.getKey());
                    break;
                }
            }
        }

        return numeroEnRomano.toString();
    }
}
