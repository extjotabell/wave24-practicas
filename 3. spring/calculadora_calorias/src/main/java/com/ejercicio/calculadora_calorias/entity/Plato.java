package com.ejercicio.calculadora_calorias.entity;

import lombok.Getter;
import lombok.Data;

import java.util.List;
@Data
@Getter
public class Plato{
    private String name;
    private List<String> ingredients;

    public Plato() {
    }

    public Plato(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

}