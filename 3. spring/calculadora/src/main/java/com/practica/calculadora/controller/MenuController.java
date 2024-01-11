package com.practica.calculadora.controller;

import com.practica.calculadora.dto.CalorieDTO;
import com.practica.calculadora.dto.IngredientDTO;
import com.practica.calculadora.service.PlateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    private final PlateService plateService;

    public MenuController(PlateService plateService) {
        this.plateService = plateService;
    }

    @GetMapping("/get-quantity-calories-by-plate/{plateName}")
    public ResponseEntity<CalorieDTO> getQuantityCaloriesByPlateName(@PathVariable String plateName) {
        return ResponseEntity.ok(plateService.getQuantityCaloriesByPlateName(plateName));
    }

    @GetMapping("/get-ingredients-by-plate/{plateName}")
    public ResponseEntity<List<IngredientDTO>> getIngredientsByPlate(@PathVariable String plateName) {
        return ResponseEntity.ok(plateService.getIngredientsByPlateName(plateName));
    }

    @GetMapping("/get-ingredient-with-max-calories/{plateName}")
    public  ResponseEntity<IngredientDTO> getIngredientWithMaxCalories(@PathVariable String plateName) {
        return ResponseEntity.ok(plateService.getIngredientWithMaxCaloriesByPlateName(plateName));
    }
}
