package org.example.calculadoracalorias.repository;

import org.example.calculadoracalorias.model.Dish;
import org.example.calculadoracalorias.model.Ingredient;

import java.util.List;

public interface IDishRepository {

    Dish findByName(String name);

    List<Ingredient> getIngredients();
}
