package org.mercadolibre.co.starwars.controller;


import org.mercadolibre.co.starwars.dto.PersonajeDTO;
import org.mercadolibre.co.starwars.service.IPersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    //@Autowired
    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/characters/{mame}")
    public ResponseEntity<List<PersonajeDTO>> findByName(@PathVariable String name) {
        var listPersonajes = this.personajeService.findByName(name);
        return ResponseEntity.ok(listPersonajes);
    }

}


