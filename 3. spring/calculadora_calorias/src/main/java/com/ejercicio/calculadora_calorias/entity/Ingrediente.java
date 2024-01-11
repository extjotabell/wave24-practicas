package com.ejercicio.calculadora_calorias.entity;

import lombok.Data;
import lombok.Getter;
@Data
@Getter
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