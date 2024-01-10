package org.covid19.covid19.controller;

import org.covid19.covid19.dto.RiskPersonDTO;
import org.covid19.covid19.entity.Person;
import org.covid19.covid19.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private static final PersonService PERSON_SERVICE = new PersonService();

    @GetMapping("/findPerson")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(PERSON_SERVICE.findAll());
    }
    @PostMapping("/savePerson")
    public ResponseEntity<Person> save(@RequestBody Person newPerson) {
        return ResponseEntity.ok(PERSON_SERVICE.save(newPerson));
    }
    @GetMapping("/findPerson/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(PERSON_SERVICE.findById(id));
    }
    @GetMapping("/findRiskPeople")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPeople() {
        return ResponseEntity.ok(PERSON_SERVICE.findRiskPeople());
    }
}
