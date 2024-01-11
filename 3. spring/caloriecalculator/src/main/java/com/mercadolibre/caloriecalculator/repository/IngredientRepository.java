package com.mercadolibre.caloriecalculator.repository;

import com.mercadolibre.caloriecalculator.entity.IngredientEntity;

public interface IngredientRepository {
    public IngredientEntity findIngredientEntityByName(String ingredientName);
}
