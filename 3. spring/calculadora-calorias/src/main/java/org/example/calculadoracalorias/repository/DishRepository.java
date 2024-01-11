package org.example.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadoracalorias.model.Dish;
import org.example.calculadoracalorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository {

    // Sample data
    private List<Dish> dishes;
    private List<Ingredient> ingredients;

    public DishRepository() {
        this.ingredients = loadData();
        this.dishes = List.of(
                new Dish("Milanesa", List.of(
                        ingredients.get(0),
                        ingredients.get(1),
                        ingredients.get(2)
                )),
                new Dish("Pizza", List.of(
                        ingredients.get(5),
                        ingredients.get(6),
                        ingredients.get(7)
                )),
                new Dish("Ensalada Cesar", List.of(
                        ingredients.get(10),
                        ingredients.get(11),
                        ingredients.get(12)
                )),
                new Dish("Hamburguesa", List.of(
                        ingredients.get(15),
                        ingredients.get(16),
                        ingredients.get(17)
                )),
                new Dish("Ensalada", List.of(
                        ingredients.get(0),
                        ingredients.get(1),
                        ingredients.get(14)
                )),
                new Dish("Pollo", List.of(
                        ingredients.get(0),
                        ingredients.get(28),
                        ingredients.get(29)
                )));
    }

    private List<Ingredient> loadData() {
        List<Ingredient> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public Dish findByName(String name) {
        return dishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
