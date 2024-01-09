package com.practica.covid19.controllers;

import com.practica.covid19.classes.Person;
import com.practica.covid19.classes.Symptom;
import com.practica.covid19.records.RiskPerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CovidController {
    private static final List<Symptom> SYMPTOMS = new ArrayList<>();
    private static final List<Person> PEOPLE = new ArrayList<>();

    static {
        SYMPTOMS.add(new Symptom("A1", "Tos", "Alto"));
        SYMPTOMS.add(new Symptom("A2", "Pulomnes", "Alto"));
        SYMPTOMS.add(new Symptom("A3", "Dolor de cabeza", "Medio"));
        SYMPTOMS.add(new Symptom("A4", "Cansancio", "Muy Alto"));
        SYMPTOMS.add(new Symptom("A5", "Mocos", "Bajo"));
        SYMPTOMS.add(new Symptom("A6", "Gripa", "Medio"));
        PEOPLE.add(new Person(1, "Marcos", "Anzurez", 27, new ArrayList<>(Arrays.asList(
                SYMPTOMS.get(0),
                SYMPTOMS.get(1),
                SYMPTOMS.get(3)
        ))));
        PEOPLE.add(new Person(2, "William", "Sanchez", 32, new ArrayList<>(Arrays.asList(
                SYMPTOMS.get(0),
                SYMPTOMS.get(2),
                SYMPTOMS.get(3),
                SYMPTOMS.get(5)
        ))));
        PEOPLE.add(new Person(3, "Carlos", "Perez", 65, new ArrayList<>(Arrays.asList(
                SYMPTOMS.get(0),
                SYMPTOMS.get(1),
                SYMPTOMS.get(2),
                SYMPTOMS.get(3)
        ))));
        PEOPLE.add(new Person(2, "Clara", "Sanchez", 62, new ArrayList<>(Arrays.asList(
                SYMPTOMS.getFirst()
        ))));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> findAllSymptoms() {
        return ResponseEntity.ok(SYMPTOMS);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Symptom> findSymptomByName(@PathVariable String name) {
        Symptom symptom = SYMPTOMS.stream().filter(
                symptom1 -> symptom1.getName().equals(name)
        ).findFirst().orElse(null);

        if (Objects.isNull(symptom))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(symptom);
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<RiskPerson>> findAllRiskPerson() {
        List<RiskPerson> riskPeople = new ArrayList<>();
        PEOPLE.stream().filter(
                person -> person.getAge()>60
        ).filter(
                person -> !person.getSymptoms().isEmpty()
        ).forEach(
                person -> riskPeople.add(new RiskPerson(person.getName(), person.getLastName(), person.getSymptoms()))
        );

        return ResponseEntity.ok(riskPeople);
    }
}