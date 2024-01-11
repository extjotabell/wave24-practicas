package com.calorias.calculadora.repository;

import com.calorias.calculadora.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements ICrudRepository<Ingredient> {

    private ArrayList<Ingredient> data;
    private String jsonFile = "classpath:json/food.json";

    public IngredientRepository() {
        this.data = this.load();
    }

    @Override
    public List<Ingredient> findAll() {
        return this.data;
    }

    @Override
    public Optional<Ingredient> findByName(String name) {
        return this.data.stream().filter(ingredient -> ingredient.getName().equalsIgnoreCase(name)).findFirst();
    }

    private ArrayList<Ingredient> load(){
        ArrayList<Ingredient> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Ingredient>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile(this.jsonFile);
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
