package com.example.food.repository;
import com.example.food.entity.Food;

import java.util.ArrayList;

public interface IFoodRepository {
    Food findByName(String name);
}