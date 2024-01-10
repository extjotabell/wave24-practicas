package org.restaurant.restaurantapi.service;

import org.restaurant.restaurantapi.model.Ingredient;
import org.restaurant.restaurantapi.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IIngredientService {
    private final IIngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByNames(List<String> names) {
        return names.stream().map(name -> this.ingredientRepository.findByName(name).orElse(null)).toList();
    }
}
