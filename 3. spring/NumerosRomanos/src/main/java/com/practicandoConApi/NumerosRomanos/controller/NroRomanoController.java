package com.practicandoConApi.NumerosRomanos.controller;

import com.practicandoConApi.NumerosRomanos.classes.NroRomanosConversor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NroRomanoController {

    @GetMapping("/convertir/{decimal}")
    public String convertirAromano(@PathVariable int decimal){
        return NroRomanosConversor.convertirAromano(decimal);
    }

}
