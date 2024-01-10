package org.covid19.covid19.controller;

import org.covid19.covid19.entity.Symptom;
import org.covid19.covid19.service.SymptomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class SymptomController {
    private static final SymptomService SYMPTOM_SERVICE = new SymptomService();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> findAll() {
        return ResponseEntity.ok(SYMPTOM_SERVICE.findAll());
    }
    @PostMapping("/saveSymptom")
    public ResponseEntity<Symptom> save(@RequestBody Symptom newSymptom) {
        return ResponseEntity.ok(SYMPTOM_SERVICE.save(newSymptom));
    }
    @GetMapping("/findSymptom/{id}")
    public ResponseEntity<Symptom> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(SYMPTOM_SERVICE.findById(id));
    }
}
