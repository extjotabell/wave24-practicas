package com.ejercicio.covid19.controller;

import com.ejercicio.covid19.classes.Person;
import com.ejercicio.covid19.classes.Symptom;
import com.ejercicio.covid19.dto.PersonSymptomsDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Symptoms")
public class SymptomController {
    private final List<Symptom> symptoms = new ArrayList<>(Arrays.asList(
            new Symptom("1", "Tos", "Leve"),
            new Symptom("2", "Fiebre","Medio"))
    );

    private  final List<Person> people = new ArrayList<>(Arrays.asList(
            new Person(1,"Maria", "Perez", 23, new ArrayList<>(List.of(symptoms.get(0), symptoms.get(1)))),
            new Person(2,"Raul", "Gonzalez", 61, new ArrayList<>(List.of(symptoms.get(1))))
    ));

    @GetMapping("/findSymptom")
    public List<Symptom> findAllSymptoms() {

        return symptoms;
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        Symptom symptom = symptoms.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (symptom != null) {
            return ResponseEntity.ok("Nivel de gravedad " + name + ": " + symptom.getSeverityLevel());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonSymptomsDTO>> getRiskPerson(){
        List<Person> personsFiltered = this.people.stream().filter(person -> person.getAge() > 60 && !person.getSymptoms().isEmpty()).toList();
        if(personsFiltered.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<PersonSymptomsDTO> listPersonSymptom = personsFiltered.stream()
                .map(person -> new PersonSymptomsDTO(person.getFirstName(), person.getLastName(), person.getSymptoms().toString()))
                .toList();
        return ResponseEntity.ok(listPersonSymptom);
    }

}
