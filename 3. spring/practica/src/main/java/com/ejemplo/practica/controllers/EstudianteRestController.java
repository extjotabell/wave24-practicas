package com.ejemplo.practica.controllers;

import com.ejemplo.practica.EstudianteDTO;
import com.ejemplo.practica.EstudiantePOJO;
import com.ejemplo.practica.EstudianteRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteRestController {

    private List<EstudiantePOJO> estudiantesPOJO = new ArrayList<>(Arrays.asList(
            new EstudiantePOJO(1, "Ludmila", "Herrera", "Argentina"),
            new EstudiantePOJO(2, "Martin", "Llanos", "Colombia" )
        )
    );

    private List<EstudianteDTO> estudiantesDTO = new ArrayList<>(Arrays.asList(
            new EstudianteDTO(1, "Ludmila", "Herrera", "Argentina"),
            new EstudianteDTO(2, "Martin", "Llanos", "Colombia" )
    )
    );

    private List<EstudianteRecord> estudiantesRecord = new ArrayList<>(Arrays.asList(
            new EstudianteRecord(1, "Ludmila", "Herrera", "Argentina"),
            new EstudianteRecord(2, "Martin", "Llanos", "Colombia" )
    )
    );

    @GetMapping()
    public ResponseEntity<List<EstudiantePOJO>> getEstudiantesPOJO() {
        return ResponseEntity.ok(estudiantesPOJO);
    }

    @GetMapping("/pojos/{id}")
    public ResponseEntity<EstudiantePOJO> getEstudiantePOJO(@PathVariable Integer id) {
        return ResponseEntity.ok(estudiantesPOJO.stream().
                filter(estudiante -> estudiante.getId().equals(id)).
                findFirst().orElseThrow());
    }

    @GetMapping("/pojos")
    public ResponseEntity<EstudiantePOJO> getEstudiantePOJOPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(estudiantesPOJO.stream().
                filter(estudiante -> estudiante.getNombre().equalsIgnoreCase(nombre)).
                findFirst().orElseThrow());
    }

    @GetMapping("/dtos/{id}")
    public ResponseEntity<EstudianteDTO> getEstudianteDTO(@PathVariable Integer id) {
        return ResponseEntity.ok(estudiantesDTO.stream().
                filter(estudiante -> estudiante.getId().equals(id)).
                findFirst().orElseThrow());
    }

    @GetMapping("/dtos")
    public ResponseEntity<EstudianteDTO> getEstudianteDTOPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(estudiantesDTO.stream().
                filter(estudiante -> estudiante.getNombre().equalsIgnoreCase(nombre)).
                findFirst().orElseThrow());
    }

    @GetMapping("/records/{id}")
    public ResponseEntity<EstudianteRecord> getEstudianteRecord(@PathVariable Integer id) {
        return ResponseEntity.ok(estudiantesRecord.stream().
                filter(estudiante -> estudiante.id().equals(id)).
                findFirst().orElseThrow());
    }

    @GetMapping("records")
    public ResponseEntity<EstudianteRecord> getEstudianteRecordPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(estudiantesRecord.stream().
                filter(estudiante -> estudiante.nombre().equalsIgnoreCase(nombre)).
                findFirst().orElseThrow());
    }

}
