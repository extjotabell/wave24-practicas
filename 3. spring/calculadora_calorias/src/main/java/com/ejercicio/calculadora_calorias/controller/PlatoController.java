package com.ejercicio.calculadora_calorias.controller;

import com.ejercicio.calculadora_calorias.dto.IngredientePlatoDTO;
import com.ejercicio.calculadora_calorias.dto.PlatoCaloriasDTO;
import com.ejercicio.calculadora_calorias.dto.PlatoMayorCaloriasDTO;
import com.ejercicio.calculadora_calorias.service.IPlatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/platos")
public class PlatoController {

    private IPlatoService iPlatoService;

    public PlatoController(IPlatoService iPlatoService) {
        this.iPlatoService = iPlatoService;
    }

    @GetMapping("/calorias/{name}")
    public ResponseEntity<PlatoCaloriasDTO> getCaloriesPorPlato(@PathVariable String name){
            return ResponseEntity.ok(iPlatoService.getCaloriasPorPlato(name));
    }

    @GetMapping("/ingredientes/{name}")
    public ResponseEntity<IngredientePlatoDTO> getIngredientsPorPlato(@PathVariable String name){
            return ResponseEntity.ok(iPlatoService.getIngredientesPorPlato(name));
    }

    @GetMapping("/mayorcalorias/{name}")
    public ResponseEntity<PlatoMayorCaloriasDTO> getHighestCalories(@PathVariable String name){
            return ResponseEntity.ok(iPlatoService.getMayorCalorias(name));
    }
}