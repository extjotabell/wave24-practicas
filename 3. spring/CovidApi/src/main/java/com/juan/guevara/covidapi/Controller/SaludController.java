package com.juan.guevara.covidapi.Controller;

import com.juan.guevara.covidapi.Clases.Persona;
import com.juan.guevara.covidapi.Clases.PersonaDTO;
import com.juan.guevara.covidapi.Clases.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/salud")
public class SaludController {

    private final List<Sintoma> sintomas = new ArrayList<>(List.of(
            new Sintoma("S1", "Fiebre", "Moderado"),
            new Sintoma("S2", "Tos seca", "Leve"),
            new Sintoma("S3", "Dificultad para respirar", "Grave")
    ));

    private final List<Persona> personas = new ArrayList<>(List.of(
            new Persona(1L, "Juan", "Pérez", 25),
            new Persona(2L, "María", "Gómez", 80),
            new Persona(3L, "Carlos", "Rodríguez", 65)
    ));

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms() {
        return ResponseEntity.ok(sintomas);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        Sintoma sintoma = buscarSintomaPorNombre(name);

        if (sintoma != null) {
            return ResponseEntity.ok("Nivel de gravedad del síntoma " + sintoma.getNombre() + ": " + sintoma.getNivelDeGravedad());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPersons() {
        List<PersonaDTO> personasRiesgo = personas.stream()
                .filter(p -> p.getEdad() > 60 && tieneSintomaAsociado(p))
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido()))
                .toList();

        return ResponseEntity.ok(personasRiesgo);
    }

    private Sintoma buscarSintomaPorNombre(String nombre) {
        return sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    private boolean tieneSintomaAsociado(Persona persona) {
        // Supongamos una lógica simple donde se asocia un síntoma al azar a cada persona
        return Math.random() < 0.5;
    }
}

