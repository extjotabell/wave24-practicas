package com.exceptions.starwars.controller;

import com.exceptions.starwars.dto.PersonajeDTO;
import com.exceptions.starwars.exception.EmptyParameterException;
import com.exceptions.starwars.service.IPersonajeService;
import com.exceptions.starwars.util.enums.CrudOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonajeController {

    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        System.out.println("Se esta inicializando el controlador.");

        this.personajeService = personajeService;
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<ArrayList<PersonajeDTO>> findByName(@PathVariable String name){

        // Controlador
        if(name.trim().isEmpty())
            throw new EmptyParameterException(CrudOperation.READ, "El parametro nombre esta vacio");

        return ResponseEntity.ok(
                this.personajeService.findByName(name)
        );
    }

}
