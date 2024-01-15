package com.CalorieCalculator.calorie.service;

import com.CalorieCalculator.calorie.dto.PlateDTO;
import com.CalorieCalculator.calorie.entity.Food;
import com.CalorieCalculator.calorie.repository.IFoodRepository;
import com.CalorieCalculator.calorie.repository.IPlateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class PlateService implements IPlateService {
    private IPlateRepository plateRepository;
    private IFoodRepository foodRepository;

    public PlateService(IPlateRepository plateRepository, IFoodRepository foodRepository) {
        this.plateRepository = plateRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public PlateDTO findByName(String name) {
        if (name.trim().isEmpty()) {
            return null;
        }

        ArrayList<Food> foods = new ArrayList<>();
        var ingredients = this.plateRepository.findByName(name);

        int totalCalories = ingredients.stream().mapToInt(ingredient->{
            var food = this.foodRepository.findByName(name);
            foods.add(food);
            return food.getCalories();
        }).sum();

        var foodList = ingredients.stream().map(ingredient -> this.foodRepository.findByName(name)).toList();
        Food foodMoreCalories = foodList
                .stream().max(Comparator.comparing(Food::getCalories)).orElse(null);

        return new PlateDTO(foodMoreCalories, foods, totalCalories);
    }
}
