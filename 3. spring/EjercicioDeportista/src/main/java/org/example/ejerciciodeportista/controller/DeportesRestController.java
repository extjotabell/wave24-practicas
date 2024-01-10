package org.example.ejerciciodeportista.controller;

import org.example.ejerciciodeportista.classes.Deporte;
import org.example.ejerciciodeportista.classes.DeportistaDTO;
import org.example.ejerciciodeportista.classes.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesRestController {
    public Persona persona1 = new Persona("Nombre1", "Apellido1", 18);
    public Persona persona2 = new Persona("Nombre2", "Apellido2", 20);
    public Deporte deporte1 = new Deporte("Futbol", "Básico");
    public Deporte deporte2 = new Deporte("Tenis", "Medio");

    public DeportistaDTO deportistaDTO1 = new DeportistaDTO(persona1.getNombre(), persona1.getApellido(), deporte1.getNombreDeporte());
    public DeportistaDTO deportistaDTO2 = new DeportistaDTO(persona2.getNombre(), persona2.getApellido(), deporte2.getNombreDeporte());
    public List<Persona> listaPersonas = new ArrayList<>(List.of(persona1, persona2));
    public List<Deporte> listaDeportes = new ArrayList<>(List.of(deporte1, deporte2));
    public List<DeportistaDTO> listaDeportistasDTO = new ArrayList<>(List.of(deportistaDTO1, deportistaDTO2));



    @GetMapping("/findSports")
    ResponseEntity<List<Deporte>> getDeportes(){
        return ResponseEntity.ok(listaDeportes);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<String> findSport(@PathVariable String name){
        return  ResponseEntity.ok(listaDeportes.stream().
                filter(deporte -> deporte.getNombreDeporte().equals(name))
                .findFirst().orElseThrow().getNivel());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findDeportistas(){
        return ResponseEntity.ok(listaDeportistasDTO);
    }
}
