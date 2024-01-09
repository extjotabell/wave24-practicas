package org.example.ejercicio.controllers;

import org.example.ejercicio.DBCovid;
import org.example.ejercicio.classes.PersonaCovid;
import org.example.ejercicio.classes.Sintoma;
import org.example.ejercicio.dtos.PersonaRiesgoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    private final List<Sintoma> sintomas = DBCovid.getSintomas();
    private final List<PersonaCovid> PersonaCovids = DBCovid.getPersonaCovids();

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
        List<PersonaRiesgoDTO> buscados = PersonaCovids.stream()
                .filter(PersonaCovid -> PersonaCovid.getEdad() >= 60 && !PersonaCovid.getSintomas().isEmpty())
                .map(PersonaCovid -> new PersonaRiesgoDTO(PersonaCovid.getNombre(), PersonaCovid.getApellido(), PersonaCovid.getSintomas().stream()
                        .map(Sintoma::getNombre)
                        .toList()))
                .toList();

        return ResponseEntity.ok(buscados);
    }
}
