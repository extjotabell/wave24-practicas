package com.calorias.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;

    @Override
    public String toString() {
        return "{" +
                "name: '" + name + '\'' +
                ", calories: " + calories +
                '}';
    }
}
