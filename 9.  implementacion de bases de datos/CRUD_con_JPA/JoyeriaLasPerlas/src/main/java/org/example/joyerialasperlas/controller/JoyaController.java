package org.example.joyerialasperlas.controller;

import org.example.joyerialasperlas.dto.JoyaDTO;
import org.example.joyerialasperlas.dto.MessageDTO;
import org.example.joyerialasperlas.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    private final JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<JoyaDTO> createJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.saveEntity(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaDTO>> getAllJoyas(){
        return new ResponseEntity<>(joyaService.getAllEntities(), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJoyaById(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.deleteEntity(id), HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JoyaDTO> updateJoya(@PathVariable Long id_modificar, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.updateEntity(id_modificar, joyaDTO), HttpStatus.OK);
    }


}
