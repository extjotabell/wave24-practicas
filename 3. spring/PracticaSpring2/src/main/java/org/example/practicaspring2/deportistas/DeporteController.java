package org.example.practicaspring2.deportistas;

import org.example.practicaspring2.deportistas.deporte.Deporte;
import org.example.practicaspring2.deportistas.deporte.DeporteDTO;
import org.example.practicaspring2.deportistas.persona.Persona;
import org.example.practicaspring2.deportistas.persona.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/deporte")
public class DeporteController {

    private final List<Deporte> deportes = Arrays.asList(
            new Deporte("Calistenia", 5),
            new Deporte("Futbol", 3),
            new Deporte("Basket", 3),
            new Deporte("Boxeo", 4)
    );

    private final List<Persona> personas = Arrays.asList(
            new Persona("Facundo", "Mamani", 24, deportes.get(0)),
            new Persona("Martin", "Gonzalez", 21, deportes.get(2)),
            new Persona("Ezequiel", "Martinez", 24, deportes.get(1))
    );

    @GetMapping("/findSports")
    @ResponseBody
    public List<DeporteDTO> findSports() {
        return deportes.stream().map(DeporteDTO::create).toList();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSportsByName(@PathVariable String name) {
        Optional<Deporte> deporteEncontrado = deportes
                .stream()
                .filter(deporte -> deporte.getNombre().equals(name))
                .findFirst();

        return deporteEncontrado
                .map(deporte -> ResponseEntity.ok("El nivel del deporte es: " + deporte.getNivel()))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons() {

        return ResponseEntity.ok(personas.stream().map(PersonaDTO::create).toList());
    }

}
