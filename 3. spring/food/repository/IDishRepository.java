package com.example.food.repository;
import com.example.food.entity.Dish;
import com.example.food.entity.Food;

import java.util.ArrayList;

public interface IDishRepository {
    Dish findByName(String name);

    ArrayList<Dish> findAllByNameAndWeight(String name, Integer weight);

}
