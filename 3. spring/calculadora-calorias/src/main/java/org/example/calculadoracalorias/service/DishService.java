package org.example.calculadoracalorias.service;

import org.example.calculadoracalorias.model.Ingredient;
import org.example.calculadoracalorias.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    private IDishRepository dishRepository;

    @Override
    public Integer getCalories(String name) {
        return dishRepository.findByName(name).getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
    }

    @Override
    public List<Ingredient> getIngredients(String name) {
        return dishRepository.findByName(name).getIngredients();
    }

    @Override
    public Ingredient getMostCaloricIngredient(String name) {
        return dishRepository.findByName(name).getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).get();
    }
}
