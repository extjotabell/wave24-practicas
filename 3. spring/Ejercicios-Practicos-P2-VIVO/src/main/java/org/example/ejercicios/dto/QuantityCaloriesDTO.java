package org.example.ejercicios.dto;

import lombok.Value;
import org.example.ejercicios.entity.Ingredient;

import java.util.List;

public record QuantityCaloriesDTO(Integer totalCalories, List<IngredientDTO> ingredientsDTO, IngredientDTO ingredientDTO) {
}
