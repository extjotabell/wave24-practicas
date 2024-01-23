package com.demospring.demo.controller;

import com.demospring.demo.dto.*;
import com.demospring.demo.service.IAlumnoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("alumnos")
@Validated
public class AlumnoController {

    @Autowired
    IAlumnoService alumnoService;


    @GetMapping("/getAll")
    public ListAllAlumnosDTO getAllAlumnos(){
        return alumnoService.findAll();
    }

    @GetMapping("/getBy")
    public ResponseEntity<AlumnoDTO> getAlumnoByDni(@RequestParam @Size(min = 6, max = 8, message = "El dni no puede contener menos de 6 caracteres ni mas de 8") String dni){
        return ResponseEntity.ok().body(alumnoService.findById(dni));
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<MessageDTO> deleteAlumnoBy(@PathVariable @Size(min = 6, max = 8, message = "El dni no puede contener menos de 6 caracteres ni mas de 8") String dni){
        return ResponseEntity.ok().body(alumnoService.deleteAlumno(dni));
    }

    @PostMapping("/create")
    public AlumnoDTO createAlumno(@RequestBody @Valid AlumnoDTO alumnoDTO){
        return alumnoService.createAlumno(alumnoDTO);
    }


}
