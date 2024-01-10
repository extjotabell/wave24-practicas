package org.restaurant.restaurantapi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.restaurant.restaurantapi.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements IIngredientRepository {
    private final List<Ingredient> ingredients;

    @Autowired
    public IngredientRepository(List<Ingredient> ingredients) {
        System.out.println("Loading ingredients from file.");
        this.ingredients = loadIngredients();
    }

    private List<Ingredient> loadIngredients() {
        ArrayList<Ingredient> ingredientsToLoad = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<ArrayList<Ingredient>> typeRef = new TypeReference<>() {};

        try {
            file = new File("src/main/resources/data/ingredients.json");
            ingredientsToLoad = objectMapper.readValue(file, typeRef);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientsToLoad;
    }
    @Override
    public Ingredient save(Ingredient entity) {
        try {
            this.ingredients.add(entity);

            return entity;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public Ingredient deleteByName(String name) {
        var ingredientToDelete = this
                .ingredients
                .stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (ingredientToDelete!= null) this.ingredients.remove(ingredientToDelete);

        return ingredientToDelete;
    }

    @Override
    public Ingredient update(Ingredient entity) {
        var ingredientToUpdate = this.ingredients.indexOf(entity);

        if (ingredientToUpdate != -1) {
            this.ingredients.set(ingredientToUpdate, entity);

            return entity;
        }

        return null;
    }

    @Override
    public Optional<Ingredient> findByName(String name) {
        return this.ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredients;
    }
}
