package com.spring.responseuno.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Plato {
    private  String nombre;
    private List<Ingrediente> listaIngredientes;
    private int peso;

    public Plato(int peso,String nombre, List<Ingrediente> listaIngredientes) {
        this.nombre = nombre;
        this.listaIngredientes = listaIngredientes;
        this.peso = peso;
    }
}
