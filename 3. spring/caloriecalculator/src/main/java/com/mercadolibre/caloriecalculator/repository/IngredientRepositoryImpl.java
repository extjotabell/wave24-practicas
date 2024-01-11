package com.mercadolibre.caloriecalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mercadolibre.caloriecalculator.entity.IngredientEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    private List<IngredientEntity> ingredients;

    public IngredientRepositoryImpl() {
        this.ingredients = loadData();
    }

    @Override
    public IngredientEntity findIngredientEntityByName(String ingredientName) {
        return this.ingredients.stream().filter(ingredientEntity -> ingredientEntity.getName().equalsIgnoreCase(ingredientName)).findFirst().orElse(null);
    }

    public List<IngredientEntity> loadData(){
        List<IngredientEntity> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<List<IngredientEntity>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/ingredients.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
