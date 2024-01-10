package com.spring.responseuno.demo.repositorio;

import com.spring.responseuno.demo.entity.Ingrediente;
import com.spring.responseuno.demo.entity.Plato;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter

public class PlatoRepositorio {
    private List<Plato> listPlatos= new ArrayList<Plato>();
    private List<Ingrediente> listIngredientes = new ArrayList<>();

    public PlatoRepositorio(){
        Ingrediente tomate = new Ingrediente("Tomate", 20);
        Ingrediente cebolla = new Ingrediente("Cebolla", 30);
        Ingrediente carne = new Ingrediente("Carne", 150);
        Ingrediente arroz = new Ingrediente("Arroz", 200);
        Ingrediente pollo = new Ingrediente("Pollo", 120);
        Ingrediente papa = new Ingrediente("Papa", 100);
        Ingrediente zanahoria = new Ingrediente("Zanahoria", 50);
        Ingrediente lechuga = new Ingrediente("Lechuga", 15);
        Ingrediente queso = new Ingrediente("Queso", 90);
        Ingrediente huevo = new Ingrediente("Huevo", 70);
        listIngredientes.add(tomate);
        listIngredientes.add(cebolla);
        listIngredientes.add(carne);
        listIngredientes.add(arroz);
        listIngredientes.add(pollo);
        listIngredientes.add(papa);
        listIngredientes.add(zanahoria);
        listIngredientes.add(lechuga);
        listIngredientes.add(queso);
        listIngredientes.add(huevo);


        // Crear platos con ingredientes
        List<Ingrediente> ingredientesPlato1 = new ArrayList<>();
        ingredientesPlato1.add(tomate);
        ingredientesPlato1.add(cebolla);
        Plato plato1 = new Plato(300, "Ensalada Fresca", ingredientesPlato1);
        listPlatos.add(plato1);

        List<Ingrediente> ingredientesPlato2 = new ArrayList<>();
        ingredientesPlato2.add(carne);
        ingredientesPlato2.add(arroz);
        Plato plato2 = new Plato(500, "Arroz con Carne", ingredientesPlato2);
        listPlatos.add(plato2);

        List<Ingrediente> ingredientesPlato3 = new ArrayList<>();
        ingredientesPlato3.add(pollo);
        ingredientesPlato3.add(papa);
        ingredientesPlato3.add(zanahoria);
        Plato plato3 = new Plato(400, "Pollo al Horno", ingredientesPlato3);
        listPlatos.add(plato3);

        List<Ingrediente> ingredientesPlato4 = new ArrayList<>();
        ingredientesPlato4.add(queso);
        ingredientesPlato4.add(huevo);
        ingredientesPlato4.add(tomate);
        Plato plato4 = new Plato(350, "Omelette de Queso", ingredientesPlato4);
        listPlatos.add(plato4);
    }
}
