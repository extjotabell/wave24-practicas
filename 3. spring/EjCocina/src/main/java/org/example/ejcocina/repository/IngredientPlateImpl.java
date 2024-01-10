package org.example.ejcocina.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejcocina.entity.Ingredient;
import org.example.ejcocina.entity.Plate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientPlateImpl implements IIngredientRepository{

    private final List<Ingredient> ingredients;

    public IngredientPlateImpl() {
        ingredients = loadData();
    }

    private List<Ingredient> loadData() {
        ArrayList<Ingredient> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<ArrayList<Ingredient>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Ingredient save() {
        return null;
    }

    @Override
    public Ingredient update() {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById() {
        return null;
    }

    @Override
    public Ingredient findIngredientEntityByName(String ingredientName) {
        return this.ingredients.stream().filter(ingredientEntity -> ingredientEntity.getName().equalsIgnoreCase(ingredientName)).findFirst().orElse(null);
    }
}
