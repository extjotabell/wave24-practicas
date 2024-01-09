package com.practica.deportistas.controllers;

import com.practica.deportistas.records.SportPerson;
import com.practica.deportistas.classes.Deporte;
import com.practica.deportistas.classes.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DeportistaController {
    List<Deporte> deportes = new ArrayList<>(Arrays.asList(
            new Deporte("Futbol", 1),
            new Deporte("Volleyball", 2),
            new Deporte("Basquetball", 3)
    ));

    List<Persona> persons = new ArrayList<>(Arrays.asList(
            new Persona("Marcos", "Anzurez", 26, deportes.getFirst()),
            new Persona("Carlos", "Perez", 24, deportes.getLast()),
            new Persona("William", "Martinez", 29, null)
    ));

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeportes(){
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getDeporte(@PathVariable String name) {
        return ResponseEntity.ok(deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().orElse(null));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPerson>> getSportPersons() {
        List<SportPerson> sportPeople = new ArrayList<>();
        persons.stream().filter(
                persona -> persona.getDeporte()!=null
        ).forEach(
                person -> sportPeople.add(new SportPerson(person.getNombre(), person.getApellido(), person.getDeporte().getNombre()))
        );
        return ResponseEntity.ok(sportPeople);
    }
}