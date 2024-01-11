package com.example.calculadoracalorias.controllers;

import com.example.calculadoracalorias.dtos.PlatoConMayorCalorias;
import com.example.calculadoracalorias.dtos.IngredientesPorPlato;
import com.example.calculadoracalorias.dtos.CaloriasPorPlato;
import com.example.calculadoracalorias.services.interfaces.PlatoServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class PlatoController {

    private final PlatoServiceInt platoServiceInt;

    @GetMapping("/{name}/calories")
    public ResponseEntity<CaloriasPorPlato> getCaloriesByPlato(@PathVariable String name){
        CaloriasPorPlato caloriasPorPlato = platoServiceInt.getCaloriesByPlato(name);
        return ResponseEntity.ok(caloriasPorPlato);
    }

    @GetMapping("/{name}/ingredients")
    public ResponseEntity<IngredientesPorPlato> getIngredientsByPlato(@PathVariable String name){
        IngredientesPorPlato ingredientesPorPlato = platoServiceInt.getIngredientePorPlato(name);
        return ResponseEntity.ok(ingredientesPorPlato);
    }

    @GetMapping("/{name}/highestCalories")
    public ResponseEntity<PlatoConMayorCalorias> getHighestCalories(@PathVariable String name){
        PlatoConMayorCalorias highestCalorie = platoServiceInt.getHighestCalorie(name);
        return ResponseEntity.ok(highestCalorie);
    }


}
