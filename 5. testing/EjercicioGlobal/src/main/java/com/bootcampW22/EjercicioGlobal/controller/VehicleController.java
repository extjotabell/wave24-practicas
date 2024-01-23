package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.MessageDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleWithoutIdDto;
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
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> postVehicle(@RequestBody VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.OK);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color,year), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable("id") Integer id, @RequestParam(value = "max_speed") Integer speed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, speed), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<MessageDto> getAveragePassangerByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAveragePassangersByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> postVehicles(@RequestBody List<VehicleDto> vehicleDtos){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicleDtos), HttpStatus.OK);
    }
}
