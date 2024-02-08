package com.bootcamp.Joyas.controller;

import com.bootcamp.Joyas.dto.JoyaDTO;
import com.bootcamp.Joyas.entity.Joya;
import com.bootcamp.Joyas.service.interfaces.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createJewerly(@RequestBody JoyaDTO joyaDTO) {
        Long id = this.joyaService.createJewerly(joyaDTO);
        return ResponseEntity.ok("Jewerly created with id: "+id);
    }

    @GetMapping()
    public ResponseEntity<List<Joya>> getAll() {
        return ResponseEntity.ok(this.joyaService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewerly(@PathVariable Long id) {
        this.joyaService.deleteJewerly(id);
        return ResponseEntity.ok("Jewerly deleted with id: "+id);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<Joya> updateJewerly(@PathVariable Long id_modificar, @RequestBody JoyaDTO joyaDTO) {
        Joya joya = this.joyaService.updateJewerly(id_modificar, joyaDTO);
        return ResponseEntity.ok(joya);
    }
}
