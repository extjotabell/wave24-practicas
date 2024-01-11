package com.example.calculadoracalorias.dtos;

import com.example.calculadoracalorias.entities.Ingrediente;

import java.util.List;

public record IngredientesPorPlato(List<Ingrediente> ingredientes) {
}
