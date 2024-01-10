package com.bootcamp.calories.dto;


import java.util.List;

public record QuantityCaloriesDTO(Integer totalCalories, List<IngredientDTO> ingredientsDTO, IngredientDTO ingredientDTO) {
}