package com.ejercicio.calculadora_calorias.service;

import com.ejercicio.calculadora_calorias.dto.IngredientePlatoDTO;
import com.ejercicio.calculadora_calorias.dto.PlatoCaloriasDTO;
import com.ejercicio.calculadora_calorias.dto.PlatoMayorCaloriasDTO;
import com.ejercicio.calculadora_calorias.entity.Plato;

public interface IPlatoService<ENTITY> {
    PlatoCaloriasDTO getCaloriasPorPlato(String name);
    IngredientePlatoDTO getIngredientesPorPlato(String name);
    PlatoMayorCaloriasDTO getMayorCalorias(String name);
}
