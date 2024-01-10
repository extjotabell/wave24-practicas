package org.example.dtopractica.controller;

import org.example.dtopractica.classes.Deporte;
import org.example.dtopractica.classes.Persona;
import org.example.dtopractica.classes.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaRestController {
    Persona persona1 = new Persona("Juan", "Perez", 30);
    Persona persona2 = new Persona("Maria", "Gonzalez", 25);
    Deporte deporte1 = new Deporte("Futbol", "Profesional");
    Deporte deporte2 = new Deporte("Tenis", "Principiante");
    List<Deporte> deportes = List.of(deporte1, deporte2);

    List<Persona> personas = List.of(persona1, persona2);

    @GetMapping("/findSports")
    private ResponseEntity<List<Deporte>> obtenerDeportesRE() {
        if (deportes.stream().findAny().isPresent()) {
            return ResponseEntity.ok(deportes);
        }
        return ResponseEntity.notFound().build();
    }

    /*@GetMapping("/findSports")
    private  List<Deporte> obtenerDeportes() {
        return deportes;
    }*/

    @GetMapping("/findSports/{name}")
    private ResponseEntity<List<Deporte>> obtenerDeportesRE(@PathVariable("name") String nombre) {
        if(deportes.stream().findAny().isPresent()) {
            var deporteEncontrado = deportes.stream().filter(deporte -> deporte.getNombre().equals(nombre));
            return ResponseEntity.ok(deporteEncontrado.toList());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    private List<PersonaDTO> obtenerPersonasDeportistas(){
        PersonaDTO personaDTO = new PersonaDTO(persona1.getNombre(), persona1.getApellidos(), deporte1.getNombre());
        PersonaDTO personaDTO2 = new PersonaDTO(persona2.getNombre(), persona2.getApellidos(), deporte2.getNombre());
        return List.of(personaDTO, personaDTO2);
    }

}
