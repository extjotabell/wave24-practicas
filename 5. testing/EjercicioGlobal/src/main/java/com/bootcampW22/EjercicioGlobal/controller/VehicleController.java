package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.CreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<List<CreateVehicleDTO>> createVehicles(@RequestBody List<VehicleDto> vehiclesDTO){
        return ResponseEntity.ok(this.vehicleService.createVehiclesBatch(vehiclesDTO));
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehicleByDimensions(
            @RequestParam String length,
            @RequestParam String width
    ){
        String[] lengthSplited = length.split("-");
        String[] widthSplited = width.split("-");
        Double minLength = Double.valueOf(lengthSplited[0]);
        Double maxLength = Double.valueOf(lengthSplited[1]);
        Double minWidth = Double.valueOf(widthSplited[0]);
        Double maxWidth = Double.valueOf(widthSplited[1]);
        return ResponseEntity.ok(this.vehicleService.findByDimensions(minLength, maxLength, minWidth, maxWidth));
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<VehicleDto> updateFuelVehicle(@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(this.vehicleService.updateFuel(vehicleDto));
    }
}
