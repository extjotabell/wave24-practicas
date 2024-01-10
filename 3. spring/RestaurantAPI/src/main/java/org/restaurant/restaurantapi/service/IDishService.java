package org.restaurant.restaurantapi.service;

import org.restaurant.restaurantapi.dto.CaloriesByDishDTO;
import org.restaurant.restaurantapi.dto.DishInformationDTO;
import org.restaurant.restaurantapi.model.Dish;
import org.restaurant.restaurantapi.model.Ingredient;

import java.util.List;

public interface IDishService {
    Integer totalCalories(String dishName);
    Ingredient highestCaloricIngredient(String dishName);
    List<Ingredient> ingredientsByDish(String dishName);
}
