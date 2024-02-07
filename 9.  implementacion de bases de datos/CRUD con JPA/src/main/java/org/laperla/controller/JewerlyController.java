package org.laperla.controller;

import org.laperla.dtos.JewerlyRequestDTO;
import org.laperla.service.JewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    @Autowired
    private JewerlyService jewerlyService;

    @PostMapping("/new")
    public ResponseEntity<String> newJewerly(@RequestBody JewerlyRequestDTO jewerlyRequestDTO) {
        return ResponseEntity.ok(jewerlyService.newJewerly(jewerlyRequestDTO));
    }
}
