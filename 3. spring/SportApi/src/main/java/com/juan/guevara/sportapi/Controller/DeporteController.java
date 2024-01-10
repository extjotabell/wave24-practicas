package com.juan.guevara.sportapi.Controller;

import com.juan.guevara.sportapi.Clases.Deporte;
import com.juan.guevara.sportapi.Clases.Persona;
import com.juan.guevara.sportapi.Clases.PersonaDeportistaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {
    private final List<Deporte> deportes = new ArrayList<>(List.of(
            new Deporte("Fútbol", "Avanzado"),
            new Deporte("Natación", "Intermedio"),
            new Deporte("Ciclismo", "Principiante")
    ));
    private final List<Persona> personas = new ArrayList<>(List.of(
            new Persona("Juan", "Pérez", 25, deportes.get(0)),
            new Persona("María", "Gómez", 30, deportes.get(1)),
            new Persona("Carlos", "Rodríguez", 22, deportes.get(2))
    ));

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findAllSports() {
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        List<PersonaDeportistaDTO> personasDeportistas = personas.stream()
                .filter(p -> p.getDeporte() != null)
                .map(p -> new PersonaDeportistaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                .toList();
        return ResponseEntity.ok(personasDeportistas);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Deporte deporte = buscarDeportePorNombre(name);

        if (deporte != null) {
            return ResponseEntity.ok("Nivel del deporte " + deporte.getNombre() + ": " + deporte.getNivel());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private Deporte buscarDeportePorNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
