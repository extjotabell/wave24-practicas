package com.example.food.controller;

import com.example.food.entity.Food;
import com.example.food.service.IDishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    private IDishService dishService;

    public FoodController(IDishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/totalCalories/{name}")
    public ResponseEntity<Integer> totalCalorias(@PathVariable String name) {
        var menu = dishService.findByName(name);
        return ResponseEntity.ok(menu.totalCalories());
    }

    @GetMapping("/ingredientsList/{name}")
    public ResponseEntity<List<Food>> obtenerIngredientes(@PathVariable String name) {
        var menu = dishService.findByName(name);
        return ResponseEntity.ok(menu.ingredients());
    }
    @GetMapping("/higherCalories/{name}")
    public ResponseEntity<Food>  obtenerIngredienteMasCalorico(@PathVariable String name) {
        var menu = dishService.findByName(name);
        return ResponseEntity.ok(menu.higherCalories());
    }
}