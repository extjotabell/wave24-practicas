package com.spring.responseuno.demo.controller;

import com.spring.responseuno.demo.entity.Ingrediente;
import com.spring.responseuno.demo.entity.Plato;
import com.spring.responseuno.demo.repositorio.PlatoRepositorio;
import com.spring.responseuno.demo.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {

    @Autowired
    PlatoService ps;


    @GetMapping("/calorias/{nombrePlato}")
    public ResponseEntity<Integer> caloriasDelPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<Integer>( ps.getCaloriasTotales(nombrePlato), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/{nombrePlato}")
    public ResponseEntity<List<Ingrediente>> ingredientesDelPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<List<Ingrediente>>( ps.getIngredientesPlato(nombrePlato),HttpStatus.OK);
    }

    @GetMapping("/ingredienteMax/{nombrePlato}")
    public ResponseEntity<Ingrediente> ingredienteMaximo(@PathVariable String nombrePlato){
        return new ResponseEntity<Ingrediente>(ps.IngredienteMasCalorias(nombrePlato),HttpStatus.OK);
    }



}
