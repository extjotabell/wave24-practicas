package com.JoyeriaLasPerlas.JoyeriaLasPerlas.controller;

import com.JoyeriaLasPerlas.JoyeriaLasPerlas.dto.JoyaDTO;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.service.interfaces.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @GetMapping("")
    public ResponseEntity<List<JoyaDTO>> getAll(){
        return ResponseEntity.ok(
                joyaService.getAllEntities()
        );
    }

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody JoyaDTO joyaDTO){
        JoyaDTO nuevaJoya = joyaService.saveEntity(joyaDTO);

        String mensaje = "Nueva joya creada con número identificatorio: " + nuevaJoya.id();
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> logicDeleteJewely(@PathVariable Integer id) {
        joyaService.eliminadoLogicoJoya(id);
        return ResponseEntity.ok("Joya eliminada lógicamente con ID: " + id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> updateJewerly(@PathVariable Integer id, @RequestBody JoyaDTO joyaDTO) {
        JoyaDTO joyaActualizada = joyaService.actualizarJoya(id, joyaDTO);
        return ResponseEntity.ok(joyaActualizada);
    }

}
