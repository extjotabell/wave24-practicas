package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @GetMapping("/analyzeScores/{studentId}")
    public ResponseEntity<StudentWithMessageDTO> analyzeScores(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.analyzeScores(studentId));
    }
}
