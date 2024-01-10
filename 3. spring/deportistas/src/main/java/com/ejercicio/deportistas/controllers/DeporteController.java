package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.classes.Person;
import com.ejercicio.deportistas.classes.Sport;
import com.ejercicio.deportistas.dto.SportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sports")
public class DeporteController {
    private static List<Sport> sports = new ArrayList<>();
    private static List<Person> people = new ArrayList<>();

    @GetMapping("/findSports")
    public List<Sport> findAllSports() {
        return sports;
    }
    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Sport sport = sports.stream()
                .filter(s -> s.getSportName().equals(name))
                .findFirst()
                .orElse(null);

        if (sport != null) {
            return ResponseEntity.ok("Nivel del deporte " + name + ": " + sport.getLevel());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    public List<SportDTO> findSportsPersons() {
        return people.stream()
                .filter(p -> p.getSport() != null)
                .map(p -> new SportDTO(p.getFirstName(), p.getLastName(), p.getSport()))
                .collect(Collectors.toList());
    }
    @PostMapping("/addSport")
    public static void addSport(@RequestBody Sport sport) {
        sports.add(sport);
    }

    @PostMapping("/addPerson")
    public static void addPerson(@RequestBody Person person) {
        people.add(person);
    }
}