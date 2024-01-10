package com.mercadolibre.covidexercise.controller;

import com.mercadolibre.covidexercise.classes.Person;
import com.mercadolibre.covidexercise.classes.Symptom;
import com.mercadolibre.covidexercise.dto.PersonSymptomDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class SymtomController {
    private final List<Symptom> SYMPTOMS = new ArrayList<>(List.of(
            new Symptom("123-1", "dolor", 1),
            new Symptom("124-1", "fiebre", 2),
            new Symptom("121-1", "sueño", 3)
    ));

    private final List<Person> PERSONS = new ArrayList<>(List.of(
            new Person("1", "Joaco", "Cabello", 25, new ArrayList<>(List.of(SYMPTOMS.get(0), SYMPTOMS.get(1)))),
            new Person("2", "Alejandro", "Knubel", 25, new ArrayList<>(List.of(SYMPTOMS.get(0)))),
            new Person("3", "Doris", "Salazar", 25, new ArrayList<>(List.of(SYMPTOMS.get(2)))),
            new Person("4", "Victoria", "Marquez", 65, new ArrayList<>(List.of(SYMPTOMS.get(0), SYMPTOMS.get(2)))),
            new Person("5", "Enzo", "Comba", 25, new ArrayList<>(List.of(SYMPTOMS.get(2), SYMPTOMS.get(1))))
    ));

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> getAllSymptom(){
        return ResponseEntity.ok(this.SYMPTOMS);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> getSymptomByName(@PathVariable String name){
        Symptom symptomFinded = this.SYMPTOMS.stream().filter(symptom -> symptom.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        if(symptomFinded != null){
            return ResponseEntity.ok(symptomFinded.getSeverityLevel());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonSymptomDTO>> getRiskPerson(){
        List<Person> personsFiltered = this.PERSONS.stream().filter(person -> person.getAge() > 60 && !person.getSymptoms().isEmpty()).toList();
        if(personsFiltered.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<PersonSymptomDTO> personSymptomDTOS = personsFiltered.stream().map(person -> new PersonSymptomDTO(person.getFirstName(), person.getLastName())).toList();
        return ResponseEntity.ok(personSymptomDTOS);
    }
}
