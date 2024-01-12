package com.bootcamp.calories.controller;

import com.bootcamp.calories.dto.IngredientDTO;
import com.bootcamp.calories.dto.QuantityCaloriesDTO;
import com.bootcamp.calories.service.PlateService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public void redirectToTwitter(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("https://google.com");
    }
}