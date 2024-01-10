package org.restaurant.restaurantapi.service;

import org.restaurant.restaurantapi.model.Ingredient;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> findByNames(List<String> names);
}
