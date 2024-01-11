package org.example.calculadoracalorias.controller;

import org.example.calculadoracalorias.dto.CaloriesDTO;
import org.example.calculadoracalorias.dto.DishDTO;
import org.example.calculadoracalorias.model.Ingredient;
import org.example.calculadoracalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriesController {

    @Autowired
    private IDishService dishService;

    @PostMapping("/calories")
    public CaloriesDTO getCalories(@RequestBody DishDTO dish) {
        return new CaloriesDTO(dishService.getCalories(dish.name()));
    }

    @PostMapping("/ingredients")
    public List<Ingredient> getIngredients(@RequestBody DishDTO dish) {
        return dishService.getIngredients(dish.name());
    }

    @PostMapping("/mostCaloricIngredient")
    public Ingredient getMostCaloricIngredient(@RequestBody DishDTO dish) {
        return dishService.getMostCaloricIngredient(dish.name());
    }
}
