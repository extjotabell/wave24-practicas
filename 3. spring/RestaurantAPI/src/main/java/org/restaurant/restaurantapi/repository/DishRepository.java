package org.restaurant.restaurantapi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.restaurant.restaurantapi.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepository implements IDishRepository {
    private final List<Dish> dishes;

    @Autowired
    public DishRepository(List<Dish> dishes) {
        System.out.println("DishRepository constructor called.");
        this.dishes = loadDishes();
    }

    private List<Dish> loadDishes() {
        ArrayList<Dish> ingredientsToLoad = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<ArrayList<Dish>> typeRef = new TypeReference<>() {};

        try {
            file = new File("src/main/resources/data/dishes.json");
            ingredientsToLoad = objectMapper.readValue(file, typeRef);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientsToLoad;
    }

    @Override
    public Dish save(Dish entity) {
        try {
            this.dishes.add(entity);

            return entity;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public Dish deleteByName(String name) {
        var dishesToDelete = this
                .dishes
                .stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (dishesToDelete!= null) this.dishes.remove(dishesToDelete);

        return dishesToDelete;
    }

    @Override
    public Dish update(Dish entity) {
        var dishesToUpdate = this.dishes.indexOf(entity);

        if (dishesToUpdate != -1) {
            this.dishes.set(dishesToUpdate, entity);

            return entity;
        }

        return null;
    }

    @Override
    public Optional<Dish> findByName(String name) {
        System.out.println(this.dishes);
        return this.dishes.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();
    }

    @Override
    public List<Dish> findAll() {
        return this.dishes;
    }
}
