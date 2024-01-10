package org.covid19.ejerciciocovid19.controllers;

import org.covid19.ejerciciocovid19.dto.PacienteDTO;
import org.covid19.ejerciciocovid19.models.Sintomas;
import org.covid19.ejerciciocovid19.services.PacienteDTOService;
import org.covid19.ejerciciocovid19.services.SintomasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidRestController {
    SintomasService sintomasService = new SintomasService();
    PacienteDTOService pacienteDTOService = new PacienteDTOService();

    @GetMapping("/findSymptom")
    private ResponseEntity<List<Sintomas>> obtenerSintomas() {
        try {
            return ResponseEntity.ok(sintomasService.obtenerSintomas());
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/findSymptom/{name}")
    private ResponseEntity<Sintomas> obtenerSintomaPorNombre(@PathVariable String name) {
        try {
            return ResponseEntity.ok(sintomasService.obtenerSintomaPorNombre(name));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/findRiskPerson")
    private ResponseEntity<List<PacienteDTO>> obtenerPacientes() {
        try {
            return ResponseEntity.ok(pacienteDTOService.obtenerPacientes());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
