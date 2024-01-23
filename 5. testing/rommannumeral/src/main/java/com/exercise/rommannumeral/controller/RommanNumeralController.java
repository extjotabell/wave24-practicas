package com.exercise.rommannumeral.controller;

import com.exercise.rommannumeral.service.RommanNumeralService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("romman-numeral")
@Validated
public class RommanNumeralController {
    private RommanNumeralService rommanNumeralService;

    public RommanNumeralController(RommanNumeralService rommanNumeralService) {
        this.rommanNumeralService = rommanNumeralService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> transformNumberToRomman(
            @PathVariable @Min(value = 1, message = "El numero debe ser mayor a 0") Integer number
    ){
        System.out.println(number);
        return ResponseEntity.ok(rommanNumeralService.transformNumberToRomman(number));
    }
}
