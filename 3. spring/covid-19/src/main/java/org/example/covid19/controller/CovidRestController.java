package org.example.covid19.controller;

import org.example.covid19.Database;
import org.example.covid19.dto.PersonaRiesgoDTO;
import org.example.covid19.model.Persona;
import org.example.covid19.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CovidRestController {
    private final List<Sintoma> sintomas = Database.getSintomas();
    private final List<Persona> personas = Database.getPersonas();

    @GetMapping("/findSymptoms")
    public ResponseEntity<List<Sintoma>> findSymptoms() {
        return ResponseEntity.ok(sintomas);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptom(@PathVariable String name) {
        Sintoma sintomaBuscado = sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equals(name))
                .findFirst()
                .orElse(null);

        return sintomaBuscado != null ? ResponseEntity.ok(sintomaBuscado) : ResponseEntity.notFound().build();
    }

    @GetMapping("/findRiskPersons")
    public ResponseEntity<List<PersonaRiesgoDTO>> findRiskPersons() {
        List<PersonaRiesgoDTO> buscados = personas.stream()
                .filter(persona -> persona.getEdad() >= 60 && !persona.getSintomas().isEmpty())
                .map(persona -> new PersonaRiesgoDTO(persona.getNombre(), persona.getApellido(), persona.getSintomas().stream()
                        .map(Sintoma::getNombre)
                        .toList()))
                .toList();

        return ResponseEntity.ok(buscados);
    }


}
