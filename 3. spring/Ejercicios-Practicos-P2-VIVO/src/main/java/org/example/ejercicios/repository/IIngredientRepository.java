package org.example.ejercicios.repository;

import org.example.ejercicios.entity.Ingredient;

public interface IIngredientRepository extends ICrudRepository<Ingredient> {
    public Ingredient findIngredientEntityByName(String ingredientName);
}