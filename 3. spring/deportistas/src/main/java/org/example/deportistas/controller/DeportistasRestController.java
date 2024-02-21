package org.example.deportistas.controller;

import org.example.deportistas.dto.DeportistaDTO;
import org.example.deportistas.model.Deporte;
import org.example.deportistas.model.Persona;
import org.example.deportistas.service.IDeporteService;
import org.example.deportistas.service.IPersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class DeportistasRestController {

    IDeporteService deporteService;
    IPersonaService personaService;

    public DeportistasRestController(IDeporteService deporteService, IPersonaService personaService) {
        this.deporteService = deporteService;
        this.personaService = personaService;
    }


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        List<Deporte> deportes = deporteService.findSports();
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<Deporte> findDeporte(@PathVariable String nombre) {
        Deporte deporte = deporteService.findSport(nombre);
        return deporte != null ? ResponseEntity.ok(deporte) : ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<Persona> personas = personaService.findPersons();
        List<DeportistaDTO> deportistas = personas.stream().map(persona -> {
            if (persona.getDeporte() != null) {
                return new DeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
            }
            return null;
        }).filter(Objects::nonNull).toList();

        return ResponseEntity.ok(deportistas);
    }

}
