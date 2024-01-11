package com.example.concesionaria.controllers;

import com.example.concesionaria.dtos.NewVehicle;
import com.example.concesionaria.dtos.VehicleDTO;
import com.example.concesionaria.services.interfaces.VehicleServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
@RequiredArgsConstructor
public class VehiclesController {

    private final VehicleServiceInt vehicleService;

    @PostMapping
    public ResponseEntity<NewVehicle> createVehicle(@RequestBody NewVehicle vehicle) {
        vehicle = vehicleService.save(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleService.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        List<VehicleDTO> vehicles = vehicleService.findVehiclesByDate(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrice(@RequestParam Double since, @RequestParam Double to) {
        List<VehicleDTO> vehicles = vehicleService.findVehiclesByPrice(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewVehicle> getVehicleById(@PathVariable Long id) {
        NewVehicle vehicle = vehicleService.findVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

}
