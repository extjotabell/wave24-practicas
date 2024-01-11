package com.mercadolibre.caloriecalculator.controller;

import com.mercadolibre.caloriecalculator.dto.IngredientDTO;
import com.mercadolibre.caloriecalculator.dto.QuantityCaloriesDTO;
import com.mercadolibre.caloriecalculator.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/get-quantity-calories-by-food/{foodName}")
    public ResponseEntity<QuantityCaloriesDTO> getQuantityCaloriesByFood(@PathVariable String foodName){
        return ResponseEntity.ok(foodService.getQuantityCaloriesByFood(foodName));
    }

    @GetMapping("/get-ingredients-by-food/{foodName}")
    public ResponseEntity<List<IngredientDTO>> getIngredientsByFood(@PathVariable String foodName){
        return ResponseEntity.ok(foodService.getIngredientsByFood(foodName));
    }

    @GetMapping("/get-ingredient-with-max-calories/{foodName}")
    public  ResponseEntity<IngredientDTO> getIngredientWithMaxCalories(@PathVariable String foodName){
        return ResponseEntity.ok(foodService.getIngredientWithMaxCalories(foodName));
    }
}
