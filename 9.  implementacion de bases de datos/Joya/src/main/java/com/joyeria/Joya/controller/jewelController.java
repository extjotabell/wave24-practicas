package com.joyeria.Joya.controller;

import com.joyeria.Joya.dto.CreateJewelDTO;
import com.joyeria.Joya.dto.JewelDTO;
import com.joyeria.Joya.service.IJewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewel")
public class jewelController {

    private final IJewelService JewelService;

    public jewelController(IJewelService JewelService) {
        this.JewelService = JewelService;
    }


    @PostMapping("/new")
    public ResponseEntity<CreateJewelDTO> create(@RequestBody JewelDTO jewelDTO) {
        return ResponseEntity.ok(
                JewelService.saveJewel(jewelDTO)
        );
    }

    @GetMapping("/")
    ResponseEntity<List<JewelDTO>> getAllJoyaController(){
        return ResponseEntity.ok(JewelService.getAllJewels());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJoyaController(@PathVariable Integer id){
        JewelService.deleteJewel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<JewelDTO> updateJoyaController(@PathVariable Long id, @RequestBody JewelDTO jewelDTO){
        return ResponseEntity.ok(JewelService.updateJewel(id, jewelDTO));
    }

}
