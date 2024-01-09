package org.example.deportistas.controller;

import org.example.deportistas.dto.DeportistaDTO;
import org.example.deportistas.model.Deporte;
import org.example.deportistas.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class DeportistasRestController {
    // Deportes
    private Deporte tenis = new Deporte("Tenis", 5);
    private Deporte futbol = new Deporte("Futbol", 4);
    private Deporte natacion = new Deporte("Natacion", 3);
    private Deporte basquet = new Deporte("Basquet", 2);

    private List<Deporte> deportes = new ArrayList<>() {{
        add(tenis);
        add(futbol);
        add(natacion);
        add(basquet);
    }};

    // Personas
    private Persona persona1 = new Persona("Juan", "Perez", 20, tenis);
    private Persona persona2 = new Persona("Pedro", "Gomez", 30, futbol);
    private Persona persona3 = new Persona("Maria", "Lopez", 40, null);
    private Persona persona4 = new Persona("Jose", "Gonzalez", 50, basquet);
    private Persona persona5 = new Persona("Ana", "Rodriguez", 60, null);

    private List<Persona> personas = new ArrayList<>() {{
        add(persona1);
        add(persona2);
        add(persona3);
        add(persona4);
        add(persona5);
    }};


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<Deporte> findDeporte(@PathVariable String nombre) {
        Deporte deporte = deportes.stream()
                .filter(d -> d.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        return deporte != null ? ResponseEntity.ok(deporte) : ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> deportistas = new ArrayList<>();
        personas.forEach(p -> {
            if (Objects.nonNull(p.getDeporte())) {
                deportistas.add(new DeportistaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()));
            }
        });

        return ResponseEntity.ok(deportistas);
    }

}
