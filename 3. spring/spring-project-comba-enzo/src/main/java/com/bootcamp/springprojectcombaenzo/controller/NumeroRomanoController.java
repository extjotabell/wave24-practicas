package com.bootcamp.springprojectcombaenzo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class NumeroRomanoController {
    private static final Map<Integer, String> numerosRomanos = new TreeMap<>(Collections.reverseOrder()){{
        put(1000,"M");
        put(900,"CM");
        put(500,"D");
        put(400,"CD");
        put(100,"C");
        put(90,"XC");
        put(50,"L");
        put(40,"XL");
        put(10,"X");
        put(9,"IX");
        put(5,"V");
        put(4,"IV");
        put(3,"III");
        put(2,"II");
        put(1,"I");
    }};
    @GetMapping("/{numero}")
    public String getNumeroRomano(@PathVariable Integer numero){
        StringBuilder numeroRomano = new StringBuilder();
        for(Map.Entry<Integer, String> entry : numerosRomanos.entrySet()){
            while(numero>0 && numero >= entry.getKey()){
                numeroRomano.append(entry.getValue());
                numero -= entry.getKey();
            }
        }
        return numeroRomano.toString();
    }
}
