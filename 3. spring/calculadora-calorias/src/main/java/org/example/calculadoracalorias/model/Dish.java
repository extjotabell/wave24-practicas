package org.example.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
