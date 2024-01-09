package com.bootcamp.dtoresponseentity.controllers;

import com.bootcamp.dtoresponseentity.classes.Person;
import com.bootcamp.dtoresponseentity.classes.Symptom;
import com.bootcamp.dtoresponseentity.dto.RiskPersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomController {
    private final List<Symptom> SYMPTOMS = new ArrayList<>(List.of(
            new Symptom(1L, "dolor", 1),
            new Symptom(1L, "fiebre", 2),
            new Symptom(1L, "sueño", 3)
    ));

    private final List<Person> PERSONS = new ArrayList<>(List.of(
            new Person(1L, "Joaco", "Cabello", 62, new ArrayList<>(List.of(SYMPTOMS.get(0), SYMPTOMS.get(1)))),
            new Person(2L, "Alejandro", "Knubel", 25, new ArrayList<>(List.of(SYMPTOMS.get(0)))),
            new Person(3L, "Doris", "Salazar", 25, new ArrayList<>(List.of(SYMPTOMS.get(2)))),
            new Person(4L, "Victoria", "Marquez", 25, new ArrayList<>(List.of(SYMPTOMS.get(0), SYMPTOMS.get(2)))),
            new Person(5L, "Enzo", "Comba", 25, new ArrayList<>(List.of(SYMPTOMS.get(2), SYMPTOMS.get(1))))
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
    public ResponseEntity<List<RiskPersonDTO>> getRiskPerson(){
        List<Person> personsFiltered = this.PERSONS.stream().filter(person -> person.getAge() > 60 && !person.getSymptoms().isEmpty()).toList();
        if(personsFiltered.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<RiskPersonDTO> personSymptomDTOS = personsFiltered.stream().map(person -> new RiskPersonDTO(person.getName(), person.getLastName())).toList();
        return ResponseEntity.ok(personSymptomDTOS);
    }

}
