package org.example.calculadoracalorias.service;

import org.example.calculadoracalorias.model.Ingredient;
import java.util.List;

public interface IDishService {
    Integer getCalories(String name);

    List<Ingredient> getIngredients(String name);

    Ingredient getMostCaloricIngredient(String name);
}
