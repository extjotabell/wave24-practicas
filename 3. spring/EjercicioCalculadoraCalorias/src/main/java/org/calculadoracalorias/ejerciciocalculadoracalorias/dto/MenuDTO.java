package org.calculadoracalorias.ejerciciocalculadoracalorias.dto;

import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Comida;

import java.util.ArrayList;

public record MenuDTO(
    Comida comida,
    ArrayList<Comida> comidas,
    Integer calories
) {
    public MenuDTO(Comida comida, ArrayList<Comida> comidas, Integer calories) {
        this.comida = comida;
        this.comidas = comidas;
        this.calories = calories;
    }
}
