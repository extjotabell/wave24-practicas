package org.restaurant.restaurantapi.service;

import org.restaurant.restaurantapi.model.Ingredient;
import org.restaurant.restaurantapi.repository.IDishRepository;
import org.restaurant.restaurantapi.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class DishService implements IDishService {
    private final IDishRepository dishRepository;
    private final IIngredientRepository ingredientRepository;

    @Autowired
    public DishService(IDishRepository dishRepository, IIngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public Integer totalCalories(String dishName) {
        var dish = this.dishRepository.findByName(dishName).orElse(null);

        if (dish != null) {
            try {
                return dish
                        .getIngredients()
                        .stream()
                        .map(ingredientName ->
                                Objects
                                        .requireNonNull(ingredientRepository.findByName(ingredientName).orElse(null))
                                        .getCalories()
                        ).reduce(Integer::sum)
                        .orElse(0);
            } catch (NullPointerException e) {
                System.out.printf("Ingredient not found: %s%n", e.getMessage());
            }
        }

        return null;
    }

    @Override
    public Ingredient highestCaloricIngredient(String dishName) {
        var dish = this.dishRepository.findByName(dishName).orElse(null);

        if (dish != null) {
            var res = dish
                    .getIngredients()
                    .stream()
                    .map(ingredientName -> this.ingredientRepository.findByName(ingredientName).orElse(null))
                    .sorted(Comparator.comparing(ingredient -> ingredient != null ? ingredient.getCalories() : 0))
                    .toList();

            return res.getLast();
        }

        return null;
    }

    @Override
    public List<Ingredient> ingredientsByDish(String dishName) {
        var dish = this.dishRepository.findByName(dishName).orElse(null);

        if (dish!= null) {
            return dish
                  .getIngredients()
                  .stream()
                  .map(ingredientName -> this.ingredientRepository.findByName(ingredientName).orElse(null))
                  .toList();
        }

        return null;
    }
}
