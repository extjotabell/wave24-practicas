package org.example.ejcocina.controller;

import org.example.ejcocina.dto.IngredientDTO;
import org.example.ejcocina.dto.QuantityCaloriesDTO;
import org.example.ejcocina.entity.Ingredient;
import org.example.ejcocina.service.PlateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PlateController {

    private final PlateService plateService;

    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @GetMapping("/get-quantity-calories-by-food/{plateName}")
    public ResponseEntity<QuantityCaloriesDTO> getQuantityCaloriesByPlateName(@PathVariable String plateName){
        return ResponseEntity.ok(plateService.getQuantityCaloriesByFood(plateName));
    }

    @GetMapping("/get-ingredients-by-food/{foodName}")
    public ResponseEntity<List<IngredientDTO>> getIngredientsByFood(@PathVariable String foodName){
        return null;
    }

    @GetMapping("/get-ingredient-with-max-calories/{foodName}")
    public  ResponseEntity<IngredientDTO> getIngredientWithMaxCalories(@PathVariable String foodName){
        return null;
    }

}
