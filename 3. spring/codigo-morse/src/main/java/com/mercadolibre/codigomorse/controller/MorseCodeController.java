package com.mercadolibre.codigomorse.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse-code")
public class MorseCodeController {
    @PostMapping()
    public String translateCode(@RequestBody MorseCode body){
        System.out.println("texto recibido: "+ body);
        return body.deserialize();
    }
}
