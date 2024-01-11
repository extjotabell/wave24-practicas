package com.mercadolibre.caloriecalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientEntity {
    private String name;
    private Integer calories;
}