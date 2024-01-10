package com.bootcamp.covid19.controllers;

import com.bootcamp.covid19.classes.Person;
import com.bootcamp.covid19.classes.Symptom;
import com.bootcamp.covid19.records.RiskPerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemCovidRestController {
    private static final List<Symptom> symptoms = List.of(
            new Symptom("S1", "Fiebre", "Alta"),
            new Symptom("S2", "Tos seca", "Media"),
            new Symptom("S3", "Cansancio", "Media"),
            new Symptom("S4", "Dolor de garganta", "Media"),
            new Symptom("S5", "Diarrea", "Media"),
            new Symptom("S6", "Conjuntivitis", "Media"),
            new Symptom("S7", "Dolor de cabeza", "Media"),
            new Symptom("S8", "Pérdida del sentido del olfato", "Media"),
            new Symptom("S9", "Erupciones cutáneas", "Media"),
            new Symptom("S10", "Dificultad para respirar", "Alta"),
            new Symptom("S11", "Dolor o presión en el pecho", "Alta"),
            new Symptom("S12", "Incapacidad para hablar o moverse", "Alta")
    );
    private static final List<Person> people = List.of(
            new Person(1, "Juan", "Perez", 20, List.of(
                    symptoms.get(0),
                    symptoms.get(1),
                    symptoms.get(2),
                    symptoms.get(3),
                    symptoms.get(4),
                    symptoms.get(5),
                    symptoms.get(6),
                    symptoms.get(7),
                    symptoms.get(8),
                    symptoms.get(9),
                    symptoms.get(10),
                    symptoms.get(11)
            )),
            new Person(2, "Maria", "Gonzalez", 30, List.of(
                    symptoms.get(0),
                    symptoms.get(1),
                    symptoms.get(2),
                    symptoms.get(3),
                    symptoms.get(4),
                    symptoms.get(5),
                    symptoms.get(6),
                    symptoms.get(7),
                    symptoms.get(8),
                    symptoms.get(9),
                    symptoms.get(10),
                    symptoms.get(11)
            )),
            new Person(3, "Pedro", "Gomez", 40, List.of(
                    symptoms.get(0),
                    symptoms.get(1),
                    symptoms.get(2),
                    symptoms.get(3),
                    symptoms.get(4),
                    symptoms.get(5),
                    symptoms.get(6),
                    symptoms.get(7),
                    symptoms.get(8),
                    symptoms.get(9),
                    symptoms.get(10),
                    symptoms.get(11)
            )),
            new Person(4, "Ana", "Martinez", 62, List.of(
                    symptoms.get(0),
                    symptoms.get(1),
                    symptoms.get(2),
                    symptoms.get(3),
                    symptoms.get(4),
                    symptoms.get(5),
                    symptoms.get(6),
                    symptoms.get(7),
                    symptoms.get(8),
                    symptoms.get(9),
                    symptoms.get(10),
                    symptoms.get(11)
            )),
            new Person(5, "Luis", "Rodriguez", 61, List.of(
                    symptoms.get(0),
                    symptoms.get(1),
                    symptoms.get(2),
                    symptoms.get(3),
                    symptoms.get(4),
                    symptoms.get(5),
                    symptoms.get(6),
                    symptoms.get(7),
                    symptoms.get(8),
                    symptoms.get(9),
                    symptoms.get(10),
                    symptoms.get(11)
            ))
    );

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> findSymptom() {
        return ResponseEntity.ok(symptoms);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Symptom> findSymptomByName(@PathVariable String name) {
        return ResponseEntity.ok(symptoms.stream().filter(symptom -> symptom.getName().equals(name)).findFirst().orElse(null));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPerson>> findRiskPerson() {
        List<RiskPerson> riskPeople = people.stream().filter(person -> person.getAge() > 60).map(person -> new RiskPerson(person.getName(), person.getLastName(), person.getSymptoms())).toList();
        return ResponseEntity.ok(riskPeople);
    }
}
