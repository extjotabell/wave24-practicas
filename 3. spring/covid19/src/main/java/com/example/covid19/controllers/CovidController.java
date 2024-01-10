package com.example.covid19.controllers;

import com.example.covid19.entities.Persona;
import com.example.covid19.entities.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class CovidController {

    private static final List<Sintoma> SINTOMA_LIST = new ArrayList<>();
    private static final List<Persona> PERSONA_LIST = new ArrayList<>();

    static {
        SINTOMA_LIST.add(new Sintoma("A1", "Tos", "Alto"));
        SINTOMA_LIST.add(new Sintoma("A2", "Pulmones", "Bajo"));
        SINTOMA_LIST.add(new Sintoma("A3", "Dolor cabeza", "Medio"));
        SINTOMA_LIST.add(new Sintoma("A4", "Cansancio", "Muy Alto"));
        SINTOMA_LIST.add(new Sintoma("A5", "Mocos", "Alto"));
        SINTOMA_LIST.add(new Sintoma("A6", "Gripa", "Medio"));

        PERSONA_LIST.add(new Persona(1L, "Ignacio", "Collado", 10));
        PERSONA_LIST.add(new Persona(2L, "Ignacio1", "Collado", 50));
        PERSONA_LIST.add(new Persona(3L, "Ignacio2", "Collado", 60));
        PERSONA_LIST.add(new Persona(4L, "Ignacio3", "Collado", 80));
        PERSONA_LIST.add(new Persona(5L, "Ignacio4", "Collado", 30));
        PERSONA_LIST.add(new Persona(6L, "Ignacio5", "Collado", 20));

    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSintomas(){
        return ResponseEntity.ok(SINTOMA_LIST);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSintomaByName(@PathVariable String name){
        Sintoma sintoma = SINTOMA_LIST.stream().filter(
                sintoma1 -> sintoma1.getNombre().equals(name)
        ).findFirst().orElse(null);

        if(!Objects.isNull(sintoma)){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sintoma);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Persona>> findRiskPerson(){
        List<Persona> personaList= PERSONA_LIST.stream().filter(
                persona -> persona.getEdad() >= 60
        ).toList();

        return ResponseEntity.ok(personaList);
    }

}
