package com.calorias.calculadora.service;

import com.calorias.calculadora.model.Dishes;
import com.calorias.calculadora.model.Ingredient;
import com.calorias.calculadora.repository.DishesRepository;
import com.calorias.calculadora.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishService {
    @Autowired
    DishesRepository dishes;

    @Autowired
    IngredientRepository ingredients;

    public ArrayList<String> getIngredientsByDish(String name){
        Optional<Dishes> dish =  this.dishes.findByName(name);
        return dish.isPresent() ? dish.get().getIngredients() : new ArrayList<>();
    }

    public Integer getTotalCalories(ArrayList<String> ingredientes){
        return ingredientes.stream().mapToInt((name) -> ingredients.findByName(name).get().getCalories()).sum();
    }

    public List<Ingredient> getIngredientsByNames(ArrayList<String> ingredientes){
        return ingredientes.stream().map((name) -> ingredients.findByName(name).get()).collect(Collectors.toList());
    }
}
