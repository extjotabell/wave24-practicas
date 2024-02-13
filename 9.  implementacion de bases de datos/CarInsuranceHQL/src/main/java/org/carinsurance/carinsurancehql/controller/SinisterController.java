package org.carinsurance.carinsurancehql.controller;

import org.carinsurance.carinsurancehql.dto.SinisterDTO;
import org.carinsurance.carinsurancehql.service.interfaces.ISinisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinister")
public class SinisterController {
    ISinisterService sinisterService;

    public SinisterController(ISinisterService sinisterService) {
        this.sinisterService = sinisterService;
    }

    @PostMapping
    public ResponseEntity<SinisterDTO> create(@RequestBody SinisterDTO sinisterDTO){
        return ResponseEntity.ok(sinisterService.createSinister(sinisterDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SinisterDTO>> getAll(){
        return ResponseEntity.ok(sinisterService.getListOfSinisters());
    }
}
