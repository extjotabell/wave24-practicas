package org.example.ejercicio.controllers;

import org.example.ejercicio.classes.Deporte;
import org.example.ejercicio.dtos.Deportista;
import org.example.ejercicio.classes.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DeporteController {

    private final List<Deporte> DEPORTES = new ArrayList<>(Arrays.asList(
            new Deporte("Futbol", 1),
            new Deporte("Basquetbol", 2),
            new Deporte("Baseboll", 3)
    ));

    private final List<Persona> PERSONAS = new ArrayList<>(Arrays.asList(
            new Persona("Juan", "Pérez", 25, DEPORTES.get(0)),
            new Persona("María", "Gómez", 30, DEPORTES.get(1)),
            new Persona("Carlos", "López", 22, DEPORTES.get(2))
    ));

    @GetMapping("/findSport")
    public List<Deporte> mostrarDeportes() {
        return DEPORTES;
    }


    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> encontrarDeporte(@PathVariable("name") String nombre) {
        Deporte deporte = DEPORTES.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().orElse(null);
        if(deporte != null) {
            return ResponseEntity.ok(deporte.getNivel());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public List<Deportista> mostrarDeportistas() {
        List<Deportista> deportistas = new ArrayList<>();

        for (Persona persona : PERSONAS) {
            Deportista deportista = new Deportista(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
            deportistas.add(deportista);
        }

        return deportistas;
    }
}
