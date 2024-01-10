package org.restaurant.restaurantapi.controller;

import org.restaurant.restaurantapi.dto.DishInformationDTO;
import org.restaurant.restaurantapi.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DishController {
    private final IDishService dishService;

    @Autowired
    public DishController(IDishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishInformation/{dishName}")
    public ResponseEntity<DishInformationDTO> getDishInformation(@PathVariable String dishName) {
        return ResponseEntity.ok(
                new DishInformationDTO(
                        dishService.totalCalories(dishName),
                        dishService.ingredientsByDish(dishName),
                        dishService.highestCaloricIngredient(dishName)
                )
        );
    }

    @GetMapping("/dishInformation")
    public ResponseEntity<List<DishInformationDTO>> getDishesInformation(@RequestParam String dishes) {
        var result = Arrays.stream(dishes.split(",")).map(dishName -> {
            var cleanName = dishName.trim();

            return new DishInformationDTO(
                    dishService.totalCalories(cleanName),
                    dishService.ingredientsByDish(cleanName),
                    dishService.highestCaloricIngredient(cleanName)
            );
        }).toList();

        return ResponseEntity.ok(result);
    }
}
