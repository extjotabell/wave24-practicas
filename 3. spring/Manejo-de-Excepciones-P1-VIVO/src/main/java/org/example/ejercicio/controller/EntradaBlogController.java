package org.example.ejercicio.controller;

import org.example.ejercicio.dto.EntradaBlogDTO;
import org.example.ejercicio.entity.EntradaBlog;
import org.example.ejercicio.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {

    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("")
    public ResponseEntity<Long> post(@RequestBody EntradaBlog entradaBlog) {
        return ResponseEntity.ok(entradaBlogService.saveEntradaBlog(entradaBlog));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(entradaBlogService.findById(id));
    }
}
