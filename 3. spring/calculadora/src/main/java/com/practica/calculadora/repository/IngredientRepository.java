package com.practica.calculadora.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.practica.calculadora.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements IIngredientRepository {
    private ArrayList<Ingredient> ingredients;
    private final String URL_FILE = "classpath:json/ingredients.json";

    public IngredientRepository() {
        this.ingredients = this.loadIngredentsFromJson();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        ingredient.setId(this.ingredients.size());

        if (this.ingredients.add(ingredient))
            return ingredient;

        return null;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        var id = this.ingredients.indexOf(ingredient);

        if (id != -1) {
            this.ingredients.set(id, ingredient);
            return ingredient;
        }

        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.ingredients.removeIf(ingredient -> ingredient.getId().equals(id));
    }

    @Override
    public Optional<Ingredient> findById(Integer id) {
        return this.ingredients.stream().filter(
                ingredient -> ingredient.getId().equals(id)
        ).findFirst();
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredients;
    }

    @Override
    public Optional<Ingredient> findIngredientByName(String name) {
        return this.ingredients.stream().filter(
                ingredient -> ingredient.getName().equalsIgnoreCase(name)
        ).findFirst();
    }

    public ArrayList<Ingredient> loadIngredentsFromJson() {
        ArrayList<Ingredient> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Ingredient>> typeReference = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile(URL_FILE);
            data = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
