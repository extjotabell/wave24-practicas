package com.example.food.dto;

import com.example.food.entity.Food;
import lombok.Getter;

import java.util.List;

public record MenuDto(
    String name,
    Integer totalCalories,
    List<Food> ingredients,
    Food higherCalories
) {
    public MenuDto(String name, Integer totalCalories, List<Food> ingredients, Food higherCalories) {
        this.name = name;
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.higherCalories = higherCalories;
    }
}
