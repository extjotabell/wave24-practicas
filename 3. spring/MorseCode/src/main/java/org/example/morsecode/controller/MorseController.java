package org.example.morsecode.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @GetMapping("/{code}")
    public String translateMorseCode(@PathVariable String code) {
        return code;
    }

    @PostMapping
    public String postMorseCode(@PathVariable String code) {
        return code;
    }
}
