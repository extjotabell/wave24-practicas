package com.mercadolibre.covidexercise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SymtomController {
    private final List<Symptom> SYMPTOMS = new ArrayList<>(List.of(
            new Symptom("123-1", "dolor", 1),
            new Symptom("124-1", "fiebre", 2),
            new Symptom("121-1", "sueño", 3)
    ));


    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> getAllSymptom(){
        return ResponseEntity.ok(this.SYMPTOMS);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> getSymptomByName(@PathVariable String name){
        return ResponseEntity.ok(this.SYMPTOMS.stream().filter(symptom -> symptom.getName().equals(name)).findFirst().orElseThrow().getSeverityLevel());

    }

    @GetMapping("findRiskPerson")
    public ResponseEntity getRiskPerson(){
        return null;
    }
}
