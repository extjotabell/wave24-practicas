package com.calorias.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dishes {
    private String name;
    private ArrayList<String> ingredients;
}
