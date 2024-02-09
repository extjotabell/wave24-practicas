package com.spring.responseuno.demo.controller;


import com.spring.responseuno.demo.model.Joya;
import com.spring.responseuno.demo.service.IJoyaService;
import com.spring.responseuno.demo.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;


    @PostMapping("/new")
    public ResponseEntity<?> saveJoya (@RequestBody Joya joya) {
        return ResponseEntity.ok(joyaService.saveJoya(joya));
    }

    @GetMapping("/")
    public ResponseEntity<?> getJoyas () {
        return ResponseEntity.ok(joyaService.getJoyas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findJoya (@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.findJoya(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJoya (@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.deleteJoya(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editJoya (@PathVariable Long id, @RequestBody Joya joya_modif) {
        return ResponseEntity.ok(joyaService.editJoya(id, joya_modif));
    }


}
