package com.CalorieCalculator.calorie.controller;

import com.CalorieCalculator.calorie.entity.Food;
import com.CalorieCalculator.calorie.service.IPlateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PlateController {
    private IPlateService plateService;

    public PlateController(IPlateService plateService) {
        this.plateService = plateService;
    }

    @GetMapping("/totalCalorias/{name}")
    public ResponseEntity<Integer> totalCalories(@PathVariable String name) {
        var plate = plateService.findByName(name);
        return ResponseEntity.ok(plate.calories());
    }

    @GetMapping("/listaIngredientes/{name}")
    public ResponseEntity<ArrayList<Food>> getIngredients(@PathVariable String name) {
        var plate = plateService.findByName(name);
        return ResponseEntity.ok(plate.foods());
    }
    @GetMapping("/ingredienteMayor/{name}")
    public ResponseEntity<Food>  obtenerIngredienteMasCalorico(@PathVariable String name) {
        var plate = plateService.findByName(name);
        return ResponseEntity.ok(plate.food());
    }

}
