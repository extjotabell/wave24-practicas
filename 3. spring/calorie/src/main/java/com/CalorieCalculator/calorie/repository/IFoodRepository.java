package com.CalorieCalculator.calorie.repository;

import com.CalorieCalculator.calorie.entity.Food;

public interface IFoodRepository {
    Food findByName(String name);

}
