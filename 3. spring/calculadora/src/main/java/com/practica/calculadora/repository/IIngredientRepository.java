package com.practica.calculadora.repository;

import com.practica.calculadora.entity.Ingredient;

import java.util.Optional;

public interface IIngredientRepository extends ICrudRepository<Ingredient> {
    Optional<Ingredient> findIngredientByName(String name);
}
