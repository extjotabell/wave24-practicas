package com.example.food.repository;

import com.example.food.entity.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
@Repository
public class FoodRepository implements IFoodRepository{

    ArrayList<Food> foodList;

    public FoodRepository() {
        this.foodList = loadData();
    }
    @Override
    public Food findByName(String name) {
        return this.foodList.stream()
                .filter(f -> f.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst().orElse(null);
    }

    private ArrayList<Food> loadData() {
        ArrayList<Food> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Food>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;

    }
}