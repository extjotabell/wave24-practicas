package com.example.food.service;

import com.example.food.dto.MenuDto;
import com.example.food.entity.Food;
import com.example.food.repository.IDishRepository;
import com.example.food.repository.IFoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DishService implements IDishService {
    IDishRepository dishRepository;
    IFoodRepository foodRepository;

    public DishService(IDishRepository dishRepository, IFoodRepository foodRepository) {
        this.dishRepository = dishRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public MenuDto findByName(String name) {

        if (name.trim().isEmpty()) {
            return null;
        }

        ArrayList<Food> foods = new ArrayList<>();
        List<String> ingredients = this.dishRepository.findByName(name).getIngredients();

        int totalCalories = ingredients.stream().mapToInt(ingredient->{
            Food food = this.foodRepository.findByName(ingredient);
            foods.add(food);
            return food.getCalories();
        }).sum();

        List<Food> ingredientsList = ingredients.stream().map(ingredient ->
                this.foodRepository.findByName(ingredient)).toList();

        Food higherCalories = ingredientsList.stream().max(Comparator.comparing(Food::getCalories)).orElse(null);


        return new MenuDto(name, totalCalories, ingredientsList, higherCalories);
    }

    @Override
    public ArrayList<MenuDto> findFoodByNameAndWeight(String name, Double weight) {
        return null;
    }
}