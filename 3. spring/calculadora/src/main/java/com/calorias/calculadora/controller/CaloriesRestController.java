package com.calorias.calculadora.controller;

import com.calorias.calculadora.model.Ingredient;
import com.calorias.calculadora.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CaloriesRestController {
    @Autowired
    DishService service;

    @GetMapping("/calories/{name}")
    public ResponseEntity<Integer> ingredients(@PathVariable String name){
        ArrayList<String> ingredients = this.service.getIngredientsByDish(name);
        return ResponseEntity.ok(service.getTotalCalories(ingredients));
    }

    @GetMapping("dish/{name}/ingredients")
    public ResponseEntity<List<Ingredient>> dishIngredients(@PathVariable String name){
        ArrayList<String> lista = this.service.getIngredientsByDish(name);
        return ResponseEntity.ok(this.service.getIngredientsByNames(lista));
    }

    @GetMapping("dish/{name}/calories")
    public ResponseEntity<Ingredient> dishWithMoreCalories(@PathVariable String name){
        return ResponseEntity.ok(this.service.getIngredientWithMoreCalories(name));
    }
}
