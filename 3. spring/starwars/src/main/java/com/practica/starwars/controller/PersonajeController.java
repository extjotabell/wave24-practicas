package com.practica.starwars.controller;

import com.practica.starwars.dto.PersonajeDTO;
import com.practica.starwars.service.IPersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonajeController {
    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        System.out.println("Iniciando controlador...");
        this.personajeService = personajeService;
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<ArrayList<PersonajeDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(
                this.personajeService.findByName(name)
        );
    }
}
