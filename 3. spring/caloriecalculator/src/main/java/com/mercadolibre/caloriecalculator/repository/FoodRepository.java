package com.mercadolibre.caloriecalculator.repository;

import com.mercadolibre.caloriecalculator.entity.FoodEntity;

import java.util.List;

public interface FoodRepository {
    public FoodEntity getFoodByName(String foodName);
}
