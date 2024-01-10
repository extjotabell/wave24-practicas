package org.example.ejcocina.dto;

import lombok.Value;
import org.example.ejcocina.entity.Ingredient;

import java.util.List;

public record QuantityCaloriesDTO(Integer totalCalories, List<IngredientDTO> ingredientsDTO, IngredientDTO ingredientDTO) {
}
