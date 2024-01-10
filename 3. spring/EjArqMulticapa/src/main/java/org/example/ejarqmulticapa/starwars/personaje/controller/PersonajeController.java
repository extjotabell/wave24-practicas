package org.example.ejarqmulticapa.starwars.personaje.controller;

import org.example.ejarqmulticapa.starwars.personaje.dto.PersonajeDTO;
import org.example.ejarqmulticapa.starwars.personaje.service.PersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars/personajes")
public class PersonajeController {

    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> findPersonajes(@RequestParam String name) {
        return ResponseEntity.of(personajeService.findPersonajesByName(name));
    }
}
