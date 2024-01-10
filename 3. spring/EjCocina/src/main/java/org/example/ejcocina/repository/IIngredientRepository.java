package org.example.ejcocina.repository;

import org.example.ejcocina.entity.Ingredient;

public interface IIngredientRepository extends ICrudRepository<Ingredient> {
    public Ingredient findIngredientEntityByName(String ingredientName);
}
