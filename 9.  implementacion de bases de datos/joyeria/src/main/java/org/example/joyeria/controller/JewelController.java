package org.example.joyeria.controller;

import org.example.joyeria.dto.JewelDTO;
import org.example.joyeria.model.Jewel;
import org.example.joyeria.service.IJewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @GetMapping("")
    public ResponseEntity<List<JewelDTO>> getAllJewels() {
        List<Jewel> jewels = jewelService.getAllJewels();
        return ResponseEntity.ok(jewels.stream().map(JewelDTO::new).toList());
    }

    @PostMapping("/new")
    public ResponseEntity<JewelDTO> createJewel(@RequestBody JewelDTO jewelDTO) {
        Jewel jewel = jewelService.saveJewel(jewelDTO);
        return ResponseEntity.ok(new JewelDTO(jewel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Integer id) {
        Jewel jewel = jewelService.deleteJewel(id);
        return ResponseEntity.ok(new JewelDTO(jewel));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@PathVariable Integer id, @RequestBody JewelDTO jewelDTO) {
        Jewel jewel = jewelService.updateJewel(id, jewelDTO);
        return ResponseEntity.ok(new JewelDTO(jewel));
    }
}
