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

    @GetMapping("")
    public ResponseEntity<?> getAllJewerly(){
        return ResponseEntity.ok(joyaService.getAllJoya());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id){
        if(joyaService.deleteJoya(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewerly(@PathVariable Long id, @RequestBody JoyaDto joyaDto){
        return ResponseEntity.ok(joyaService.updateJoya(id, joyaDto));
    }
}
