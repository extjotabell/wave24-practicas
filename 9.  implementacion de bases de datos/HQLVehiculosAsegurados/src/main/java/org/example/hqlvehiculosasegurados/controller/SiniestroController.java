package org.example.hqlvehiculosasegurados.controller;

import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.SiniestroDto;
import org.example.hqlvehiculosasegurados.service.SiniestroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {

    private final SiniestroService siniestroService;

    public SiniestroController(SiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping
    public ResponseEntity<SiniestroDto> saveSiniestro(@RequestBody SiniestroDto siniestroDto){
        return new ResponseEntity<>(siniestroService.save(siniestroDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SiniestroDto>> getAllSiniestros(){
        return new ResponseEntity<>(siniestroService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiniestroDto> getSiniestroById(@PathVariable Long id){
        return new ResponseEntity<>(siniestroService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateSiniestroById(@PathVariable Long id, @RequestBody SiniestroDto siniestroDto){
        return new ResponseEntity<>(siniestroService.update(id, siniestroDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteSiniestroById(@PathVariable Long id){
        return new ResponseEntity<>(siniestroService.deleteById(id), HttpStatus.OK);
    }
}
