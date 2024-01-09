package org.sports.sports.controller;

import org.sports.sports.dto.SportPersonDTO;
import org.sports.sports.entity.Sport;
import org.sports.sports.service.PersonService;
import org.sports.sports.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportRestController {
    SportService sportsService = new SportService();
    PersonService personService = new PersonService();

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getAll() {
        return ResponseEntity.ok(sportsService.getAll());
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> getByName(@PathVariable String name) {
        return ResponseEntity.ok(sportsService.getByName(name));
    }
    @GetMapping("/findSportsPeople")
    public ResponseEntity<List<SportPersonDTO>> getPersonAndSport() {
        return ResponseEntity.ok(personService.getPersonAndSport());
    }
}
