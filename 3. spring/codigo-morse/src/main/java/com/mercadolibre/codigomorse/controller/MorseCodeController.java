package com.mercadolibre.codigomorse.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/morse-code")
public class MorseCodeController {
    @PostMapping("/code-to-text")
    public String translateCode(@RequestBody MorseCode body){
        System.out.println("texto recibido: "+ body);
        return body.deserializeToText();
    }

    @PostMapping("/text-to-code")
    public String translateTextToCode(@RequestBody MorseCode body){
        System.out.println("Texto a codificar: " + body);
        return body.deserializeToCode();
    }

    @GetMapping()
    public Map<String, String> getCodes(){
        return MorseCode.CODES.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
