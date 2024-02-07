package com.mercadolibre.joyeriaexercise.controller;

import com.mercadolibre.joyeriaexercise.dto.CreateJoyaResponseDTO;
import com.mercadolibre.joyeriaexercise.dto.JoyaDTO;
import com.mercadolibre.joyeriaexercise.service.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    ResponseEntity<CreateJoyaResponseDTO> createJoyaController(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.createJoya(joyaDTO));
    }

    @GetMapping("/")
    ResponseEntity<List<JoyaDTO>> getAllJoyaController(){
        return ResponseEntity.ok(joyaService.getAllJoya());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJoyaController(@PathVariable Integer id){
        joyaService.deleteJoya(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<JoyaDTO> updateJoyaController(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.updateJoya(id, joyaDTO));
    }
}
