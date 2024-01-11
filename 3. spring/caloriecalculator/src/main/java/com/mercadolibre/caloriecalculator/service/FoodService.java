package com.mercadolibre.caloriecalculator.service;

import com.mercadolibre.caloriecalculator.dto.IngredientDTO;
import com.mercadolibre.caloriecalculator.dto.QuantityCaloriesDTO;
import com.mercadolibre.caloriecalculator.entity.FoodEntity;
import com.mercadolibre.caloriecalculator.entity.IngredientEntity;
import com.mercadolibre.caloriecalculator.repository.FoodRepository;
import com.mercadolibre.caloriecalculator.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FoodService {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private FoodRepository foodRepository;

    public QuantityCaloriesDTO getQuantityCaloriesByFood(String foodName){
        FoodEntity food = this.foodRepository.getFoodByName(foodName);
        if(Objects.isNull(food)){
            return null;
        }

        List<IngredientEntity> ingredients = food.getIngredients().stream().map(ingredientEntity -> this.ingredientRepository.findIngredientEntityByName(ingredientEntity)).toList();

        Integer maxQuantity = ingredients.stream().mapToInt(IngredientEntity::getCalories).sum();

        return new QuantityCaloriesDTO(maxQuantity);
    }

    public List<IngredientDTO> getIngredientsByFood(String foodName){
        FoodEntity food = this.foodRepository.getFoodByName(foodName);
        if(Objects.isNull(food)){
            return null;
        }

        List<IngredientEntity> ingredients = food.getIngredients().stream().map(ingredientEntity -> this.ingredientRepository.findIngredientEntityByName(ingredientEntity)).toList();

        return ingredients.stream().map(ingredientEntity -> new IngredientDTO(ingredientEntity.getName(), ingredientEntity.getCalories())).toList();
    }

    public IngredientDTO getIngredientWithMaxCalories(String foodName){
        FoodEntity food = this.foodRepository.getFoodByName(foodName);
        if(Objects.isNull(food)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el plato");
        }

        List<IngredientEntity> ingredients = food.getIngredients().stream().map(ingredientEntity -> this.ingredientRepository.findIngredientEntityByName(ingredientEntity)).toList();

        IngredientEntity ingredientMaxQuantity = ingredients.stream().max(Comparator.comparing(IngredientEntity::getCalories)).orElse(null);

        if(Objects.isNull(ingredientMaxQuantity)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el ingrediente");
        }

        return new IngredientDTO(ingredientMaxQuantity.getName(), ingredientMaxQuantity.getCalories());
    }
}
