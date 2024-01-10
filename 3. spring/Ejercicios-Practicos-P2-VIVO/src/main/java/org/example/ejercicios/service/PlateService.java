package org.example.ejercicios.service;

import org.example.ejercicios.dto.IngredientDTO;
import org.example.ejercicios.dto.QuantityCaloriesDTO;
import org.example.ejercicios.entity.Ingredient;
import org.example.ejercicios.entity.Plate;
import org.example.ejercicios.repository.IIngredientRepository;
import org.example.ejercicios.repository.IPlateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlateService {

    private final IPlateRepository iPlateRepository;
    private final IIngredientRepository iIngredientRepository;

    public PlateService(IPlateRepository iPlateRepository, IIngredientRepository iIngredientRepository) {
        this.iPlateRepository = iPlateRepository;
        this.iIngredientRepository = iIngredientRepository;
    }

    public QuantityCaloriesDTO getQuantityCaloriesByFood(String plateName) {

        Plate plate = iPlateRepository.findByName(plateName);

        List<Ingredient> ingredients = plate.getIngredients().stream().map(this.iIngredientRepository::findIngredientEntityByName).toList();

        Integer totalCalories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();

        Ingredient ingredientWithMostCalories = ingredients
                .stream()
                .max(
                        Comparator.comparing(Ingredient::getCalories)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el ingrediente")
                );

        return new QuantityCaloriesDTO(
                totalCalories,
                ingredients
                        .stream()
                        .map(ingredient ->
                                new IngredientDTO(ingredient.getName(), ingredient.getCalories()))
                        .toList(),
                new IngredientDTO(ingredientWithMostCalories.getName(), ingredientWithMostCalories.getCalories()));
    }
}