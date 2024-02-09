package org.example.joyeria.controller;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaPostResponseDTO;
import org.example.joyeria.service.JoyeriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {

    private final JoyeriaService joyeriaService;

    public JoyeriaController(JoyeriaService joyeriaService) {
        this.joyeriaService = joyeriaService;
    }

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> getJoyeria() {
        return ResponseEntity.ok(joyeriaService.getJoyeria());
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaPostResponseDTO> addJoya(JoyaDTO joyaDTO) {
        return ResponseEntity.ok(joyeriaService.addJoya(joyaDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJoya(@PathVariable Long id) {
        joyeriaService.deleteJoya(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
public ResponseEntity<JoyaDTO> updateJoya(@PathVariable Long id, JoyaDTO joyaDTO) {
        return ResponseEntity.ok(joyeriaService.updateJoya(id, joyaDTO));
    }
}
