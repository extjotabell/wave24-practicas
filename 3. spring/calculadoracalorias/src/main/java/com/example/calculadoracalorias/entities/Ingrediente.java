package com.example.calculadoracalorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Ingrediente {
    private String name;
    private int calories;

    public Ingrediente() {
    }

    public Ingrediente(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}
