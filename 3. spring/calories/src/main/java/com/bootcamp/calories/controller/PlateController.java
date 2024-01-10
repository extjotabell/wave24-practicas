package com.bootcamp.calories.controller;

import com.bootcamp.calories.dto.IngredientDTO;
import com.bootcamp.calories.dto.QuantityCaloriesDTO;
import com.bootcamp.calories.service.PlateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/food")
public class PlateController {

    private final PlateService plateService;

    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @GetMapping("/get-quantity-calories-by-food/{plateName}")
    public ResponseEntity<QuantityCaloriesDTO> getQuantityCaloriesByPlateName(@PathVariable String plateName){
        return ResponseEntity.ok(plateService.getQuantityCaloriesByFood(plateName));
    }
}