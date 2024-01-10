package com.example.calculadoracalorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Plato {
    private String name;
    private List<String> ingredients;

    public Plato() {
    }

    public Plato(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
