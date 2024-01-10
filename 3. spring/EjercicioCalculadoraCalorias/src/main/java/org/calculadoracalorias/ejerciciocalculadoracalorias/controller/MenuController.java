package org.calculadoracalorias.ejerciciocalculadoracalorias.controller;

import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Comida;
import org.calculadoracalorias.ejerciciocalculadoracalorias.service.IPlatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MenuController {
    private IPlatoService platoService;

    public MenuController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/totalCalorias/{name}")
    public ResponseEntity<Integer> totalCalorias(@PathVariable String name) {
        var plato = platoService.findByName(name);
        return ResponseEntity.ok(plato.calories());
    }

    @GetMapping("/listaIngredientes/{name}")
    public ResponseEntity<ArrayList<Comida>> obtenerIngredientes(@PathVariable String name) {
        var plato = platoService.findByName(name);
        return ResponseEntity.ok(plato.comidas());
    }
    @GetMapping("/ingredienteMayor/{name}")
    public ResponseEntity<Comida>  obtenerIngredienteMasCalorico(@PathVariable String name) {
        var plato = platoService.findByName(name);
        return ResponseEntity.ok(plato.comida());
    }

}
