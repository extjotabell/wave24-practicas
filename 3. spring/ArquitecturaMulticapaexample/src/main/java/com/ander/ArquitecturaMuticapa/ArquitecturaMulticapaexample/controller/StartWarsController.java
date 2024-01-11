package com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.controller;

import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.dto.PersonajeDTO;
import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StartWarsController {


    //hacer uso de servicio

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{personaje}/") //devuelve una lsita de personajes
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(@PathVariable String personaje){
        var personajes = this.personajeService.findByName(personaje);
        return ResponseEntity.ok(personajes);

    }

    @GetMapping("/")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(){
        var personajes = this.personajeService.findAll();
        return ResponseEntity.ok(personajes);
    }
}
