package com.example.calculadoracalorias.services.interfaces;

import com.example.calculadoracalorias.dtos.PlatoConMayorCalorias;
import com.example.calculadoracalorias.dtos.IngredientesPorPlato;
import com.example.calculadoracalorias.dtos.CaloriasPorPlato;

public interface PlatoServiceInt {
    CaloriasPorPlato getCaloriesByPlato(String name) throws RuntimeException;

    IngredientesPorPlato getIngredientePorPlato(String name) throws RuntimeException;

    PlatoConMayorCalorias getHighestCalorie(String name) throws RuntimeException;
}
