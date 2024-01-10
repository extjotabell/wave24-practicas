package org.meli.co.covid19.controller;

import org.meli.co.covid19.model.Sintoma;
import org.meli.co.covid19.service.SintomaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CovidController {


    private SintomaService sintomaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findSymptom() {
        return ResponseEntity.ok(sintomaService.getSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptomByName(@PathVariable("name") String name){
        return ResponseEntity.ok(sintomaService.getSintomaByName(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Sintoma>> findRiskPerson() {
        return ResponseEntity.ok(sintomaService.getSintomas());
    }

}
