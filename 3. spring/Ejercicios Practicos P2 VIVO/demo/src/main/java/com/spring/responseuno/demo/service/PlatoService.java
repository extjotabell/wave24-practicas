package com.spring.responseuno.demo.service;

import com.spring.responseuno.demo.entity.Ingrediente;
import com.spring.responseuno.demo.entity.Plato;
import com.spring.responseuno.demo.repositorio.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {

    @Autowired
    PlatoRepositorio pr;
    public int getCaloriasTotales(String nombrePlato){
        Plato plato = pr.getListPlatos().stream().filter(x -> x.getNombre().equals(nombrePlato)).findFirst().get();

        int total = 0;
        for (int i = 0; i <plato.getListaIngredientes().size() ; i++) {
            total= total + plato.getListaIngredientes().get(i).getCalorias();
        }

        return total;
    }

    public List<Ingrediente> getIngredientesPlato(String nombrePlato){
        Plato plato = pr.getListPlatos().stream().filter(x -> x.getNombre().equals(nombrePlato)).findFirst().get();
        return plato.getListaIngredientes();
    }

    public Ingrediente IngredienteMasCalorias(String nombrePlato){
        Plato plato = pr.getListPlatos().stream().filter(x -> x.getNombre().equals(nombrePlato)).findFirst().get();
        Optional<Ingrediente> ing = plato.getListaIngredientes().stream()
                .max(Comparator.comparing(Ingrediente::getCalorias));
        return ing.get();
    }


}
