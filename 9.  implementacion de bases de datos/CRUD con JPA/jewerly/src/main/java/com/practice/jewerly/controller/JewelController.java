package com.practice.jewerly.controller;

import com.practice.jewerly.dto.JewelDto;
import com.practice.jewerly.dto.MessageDto;
import com.practice.jewerly.service.interfaces.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewelry")
public class JewelController {
    @Autowired
    private IJewelService jewelService;

    @GetMapping("/")
    public ResponseEntity<List<JewelDto>> getAll() {
        return ResponseEntity.ok(
                jewelService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                jewelService.getById(id)
        );
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> create(@RequestBody JewelDto jewelDto) {
        return ResponseEntity.ok(
                jewelService.save(jewelDto)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(
                jewelService.deleteById(id)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDto> updateById(@PathVariable Long id,
                                                 @RequestBody JewelDto jewelDto) {
        return ResponseEntity.ok(
                jewelService.updateById(id, jewelDto)
        );
    }

}
