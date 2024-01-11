package org.starwars.ejerciciostarwars.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.starwars.ejerciciostarwars.dto.PersonajeDTO;
import org.starwars.ejerciciostarwars.exception.EmptyParameterException;
import org.starwars.ejerciciostarwars.service.IPersonajeService;
import org.starwars.ejerciciostarwars.util.enums.CrudOperation;

import java.util.ArrayList;

@RestController
public class PersonajeController {
    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/findByName/{name}")
    ResponseEntity<ArrayList<PersonajeDTO>> findByName(@PathVariable String name){
        //controlador
        if (name.trim().isEmpty())
            throw new EmptyParameterException(CrudOperation.READ,"El parametro nombre no puede estar vacío");
        return ResponseEntity.ok(this.personajeService.findByName(name));
    }
}
