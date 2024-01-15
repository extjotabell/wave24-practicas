package com.CalorieCalculator.calorie.dto;

import com.CalorieCalculator.calorie.entity.Food;

import java.util.ArrayList;
import java.util.Comparator;

public record PlateDTO (
        Food food,
        ArrayList<Food> foods,
        Integer calories
){
    public PlateDTO(Food food, ArrayList<Food> foods, Integer calories) {
        this.food = food;
        this.foods = foods;
        this.calories = calories;
    }
}

