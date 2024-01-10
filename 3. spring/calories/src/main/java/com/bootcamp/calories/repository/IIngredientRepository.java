package com.bootcamp.calories.repository;

import com.bootcamp.calories.entity.Ingredient;

public interface IIngredientRepository extends ICrudRepository<Ingredient> {
    public Ingredient findIngredientEntityByName(String ingredientName);
}