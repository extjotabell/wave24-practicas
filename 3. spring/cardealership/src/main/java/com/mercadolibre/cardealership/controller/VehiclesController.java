package com.mercadolibre.cardealership.controller;

import com.mercadolibre.cardealership.dto.CreateVechileReponseDTO;
import com.mercadolibre.cardealership.dto.VehicleDTO;
import com.mercadolibre.cardealership.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehiclesController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<CreateVechileReponseDTO> createVehicle(@RequestBody VehicleDTO vehicledto){
        return ResponseEntity.ok(vehicleService.createVehicle(vehicledto));
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> getAllsVehicles(){
        return ResponseEntity.ok(vehicleService.getAllsVehicles());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByManufacturingDate(@RequestParam String since){
        String dateFind = since.replace("\"", "").split("=")[1];
        return ResponseEntity.ok(vehicleService.getVehiclesByManufacturingDate(dateFind));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVechiclesByPrices(@RequestParam String since){
        String priceFind = since.replace("\"", "").split("=")[1];
        return ResponseEntity.ok(vehicleService.getVechiclesByPrices(priceFind));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable String id){
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }
}
