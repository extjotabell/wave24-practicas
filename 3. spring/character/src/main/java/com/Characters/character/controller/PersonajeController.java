package com.Characters.character.controller;

import com.Characters.character.dto.PersonajeDTO;
import com.Characters.character.exception.EmptyParameterException;
import com.Characters.character.service.IPersonajeService;
import com.Characters.character.util.enums.CrudOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

@RestController
public class PersonajeController {
    private final IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {

        this.personajeService = personajeService;
    }

    @GetMapping("/findByName/{name}")
    ResponseEntity<ArrayList<PersonajeDTO>> findByName(@PathVariable String name){
        if (name.trim().isEmpty())
            throw new EmptyParameterException(CrudOperation.READ,"El parametro nombre no puede estar vacío");
        return ResponseEntity.ok(this.personajeService.findByName(name));
    }
}

