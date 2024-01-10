package org.restaurant.restaurantapi.dto;

import org.restaurant.restaurantapi.model.Ingredient;

import java.util.List;

public record DishInformationDTO(Integer totalCalories, List<Ingredient> ingredients, Ingredient highestCaloricIngredient) {
}
