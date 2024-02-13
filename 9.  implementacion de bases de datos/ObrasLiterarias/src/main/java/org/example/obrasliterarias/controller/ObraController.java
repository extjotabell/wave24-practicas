package org.example.obrasliterarias.controller;
import org.example.obrasliterarias.entity.Obra;
import org.example.obrasliterarias.service.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObraController {
    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping("/obras_autor/{autor}")
    public ResponseEntity<List<Obra>> getObrasAutor(@PathVariable String autor){
        return new ResponseEntity<>(obraService.getByAutor(autor), HttpStatus.OK);
    }
}
