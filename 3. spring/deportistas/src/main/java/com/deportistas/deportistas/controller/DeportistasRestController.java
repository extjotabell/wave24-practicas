package com.deportistas.deportistas.controller;

import com.deportistas.deportistas.classes.Deporte;
import com.deportistas.deportistas.classes.DeportistaDTO;
import com.deportistas.deportistas.classes.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DeportistasRestController {

    public List<Deporte> deportes = new ArrayList<>(Arrays.asList(
            new Deporte("Fútbol", 3),
            new Deporte("Equitación", 2),
            new Deporte("Natación", 4)
    ));

    public List<Persona> personas = new ArrayList<>(Arrays.asList(
            new Persona("Juan", "Rabanillo", 34),
            new Persona("Cristopher", "Walken", 60),
            new Persona("Robert", "de Niro", 75)
    ));

    public List<DeportistaDTO> deportistas = new ArrayList<>(Arrays.asList(
            new DeportistaDTO(deportes.get(0), personas.get(0)),
            new DeportistaDTO(deportes.get(1), personas.get(1)),
            new DeportistaDTO(deportes.get(2), personas.get(2))
    ));

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> sports(){
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> sport(@PathVariable String name) {
        Optional<Deporte> sport = deportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(name)).findFirst();
        return sport.isPresent() ? ResponseEntity.ok(sport.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons(){
        return ResponseEntity.ok(deportistas);
    }
}
