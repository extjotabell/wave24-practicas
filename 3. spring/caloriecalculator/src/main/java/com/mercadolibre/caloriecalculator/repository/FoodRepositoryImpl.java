package com.mercadolibre.caloriecalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mercadolibre.caloriecalculator.entity.FoodEntity;
import com.mercadolibre.caloriecalculator.entity.IngredientEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements FoodRepository {
    private List<FoodEntity> foods;

    public FoodRepositoryImpl() {
        this.foods = loadData();
    }

    @Override
    public FoodEntity getFoodByName(String foodName) {
        return foods.stream().filter(foodEntity -> foodEntity.getName().equalsIgnoreCase(foodName)).findFirst().orElse(null);
    }

    public List<FoodEntity> loadData(){
        List<FoodEntity> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<List<FoodEntity>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
