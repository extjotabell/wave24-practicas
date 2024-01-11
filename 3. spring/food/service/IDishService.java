package com.example.food.service;

import com.example.food.dto.MenuDto;

import java.util.ArrayList;

public interface IDishService {
    MenuDto findByName(String name);

    ArrayList<MenuDto> findFoodByNameAndWeight(String name, Double weight);

}