package com.example.Deportistas.controllers;

import com.example.Deportistas.dtos.DeportistaDto;
import com.example.Deportistas.entities.Deporte;
import com.example.Deportistas.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class DeportistasController {


    private final PersonaService personaService;

    @GetMapping("/findSports")
    public ResponseEntity<Set<String>> findSports(){
        return ResponseEntity.ok(personaService.findsSports());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSports(@PathVariable String name){
        try {
            return ResponseEntity.ok(personaService.findsSports(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<DeportistaDto>> findSportsPerson(){
        return ResponseEntity.ok(personaService.findSportsPerson());
    }


}
