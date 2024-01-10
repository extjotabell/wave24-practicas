package org.mercadolibre.co.calorias.controller;


import org.mercadolibre.co.calorias.dto.IngredienteDTO;
import org.mercadolibre.co.calorias.dto.PlatoDTO;
import org.mercadolibre.co.calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {


    private IPlatoService platoService;

    public PlatoController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("/calorias")
    public ResponseEntity<List<PlatoDTO>> calcularCalorias(@RequestBody String[] platos){
        var platosFinales = platoService.getCaloriasPlatos(platos);
        return ResponseEntity.ok().body(platosFinales);

    }

    @PostMapping("/ingredientes")
    public ResponseEntity<List<IngredienteDTO>> getIngredientes(@RequestBody String[] platos){

        var ingredientes = platoService.getIngredientes(platos);

       return ResponseEntity.ok().body(ingredientes);
    }

    @PostMapping("/ingredientes/mayor")
    public ResponseEntity<List<IngredienteDTO>> getIngredienteMayor(@RequestBody String[] platos){

        var ingrediente = platoService.getIngredienteMayor(platos);

       return ResponseEntity.ok().body(ingrediente);
    }


}
