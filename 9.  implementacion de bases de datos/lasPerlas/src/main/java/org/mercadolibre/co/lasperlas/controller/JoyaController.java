package org.mercadolibre.co.lasperlas.controller;


import org.mercadolibre.co.lasperlas.dto.JoyaDto;
import org.mercadolibre.co.lasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;


    @PostMapping("/new")
    public ResponseEntity<?> createJewerly(@RequestBody JoyaDto joyaDto){
        return ResponseEntity.ok(joyaService.createJoya(joyaDto));
    }

    @GetMapping()
    public ResponseEntity<?> getAllJewerly(){
        return ResponseEntity.ok(joyaService.getAllJewerly());
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id){
        return ResponseEntity.ok(joyaService.deleteJewerly(id));
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateJewerly(@PathVariable Long id, @RequestBody JoyaDto joyaDto){
        return ResponseEntity.ok(joyaService.updateJewerly(id, joyaDto));
    }
}
