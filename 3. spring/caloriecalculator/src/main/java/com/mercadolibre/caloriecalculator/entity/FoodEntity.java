package com.mercadolibre.caloriecalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FoodEntity {
    private String name;
    private List<String> ingredients;
}
