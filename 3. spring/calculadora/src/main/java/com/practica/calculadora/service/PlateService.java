package com.practica.calculadora.service;

import com.practica.calculadora.dto.CalorieDTO;
import com.practica.calculadora.dto.IngredientDTO;
import com.practica.calculadora.entity.Ingredient;
import com.practica.calculadora.entity.Plate;
import com.practica.calculadora.repository.IngredientRepository;
import com.practica.calculadora.repository.PlateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;

@Service
public class PlateService {
    private final IngredientRepository ingredientRepository;
    private final PlateRepository plateRepository;

    public PlateService(IngredientRepository ingredientRepository, PlateRepository plateRepository) {
        this.ingredientRepository = ingredientRepository;
        this.plateRepository = plateRepository;
    }

    private Plate getPlateByName(String plateName) {
        return this.plateRepository.findPlateByName(plateName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el plato"));
    }

    private Ingredient getIngredientName(String ingredientName) {
        return this.ingredientRepository.findIngredientByName(ingredientName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el plato"));
    }

    public CalorieDTO getQuantityCaloriesByPlateName(String plateName) {
        if (plateName.trim().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombbre vacio");

        var ingredients = this.getPlateByName(plateName).getIngredients().stream().map(
                this::getIngredientName
        ).toList();

        return new CalorieDTO(
                ingredients.stream().mapToInt(
                        Ingredient::getCalories
                ).sum()
        );
    }

    public List<IngredientDTO> getIngredientsByPlateName(String plateName) {
        if (plateName.trim().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombbre vacio");

        return this.getPlateByName(
                plateName
        ).getIngredients().stream().map(
                this::getIngredientName
        ).map(
                ingredient -> new IngredientDTO(ingredient.getName(), ingredient.getCalories())
        ).toList();
    }

    public IngredientDTO getIngredientWithMaxCaloriesByPlateName(String plateName) {
        if (plateName.trim().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombbre vacio");

        var ingredientWithMostCalories = this.getPlateByName(plateName).getIngredients().stream().map(
                this::getIngredientName
        ).max(
                Comparator.comparing(Ingredient::getCalories)
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el ingrediente"));

        return new IngredientDTO(ingredientWithMostCalories.getName(), ingredientWithMostCalories.getCalories());
    }
}
