package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto v){
        return new ResponseEntity<>(vehicleService.addVehicle(v), HttpStatus.OK);
    }
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> calculateSpeed(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAverageSpeedByBrand(brand), HttpStatus.OK);
    }
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageCapacity(brand), HttpStatus.OK);
    }
}
