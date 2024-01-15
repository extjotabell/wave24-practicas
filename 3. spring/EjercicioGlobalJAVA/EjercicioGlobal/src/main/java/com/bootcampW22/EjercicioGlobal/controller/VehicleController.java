package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {


    //inyeccion de dependency services
    IVehicleService vehicleService;
    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }



    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable int id,
                                         @RequestParam String speed)
    {   vehicleService.updateSpeed(id,speed);
        return new ResponseEntity<>(new ExceptionDto("Velocidad del vehículo actualizada exitosamente."),HttpStatus.OK);
    }


    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable int id){
        return new ResponseEntity<>(vehicleService.getVehicle(id),HttpStatus.OK);
    }



    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle){
        vehicleService.createVehicule(vehicle);
        return new ResponseEntity<>(new ExceptionDto("Vehiculo creado exitosamente."),HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> filterbyColorYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.filterbyColorYear(color,year),HttpStatus.OK);
    }

    @GetMapping("vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> filterbyBrandYear(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.filterbyBrandYear(brand,start_year,end_year),HttpStatus.OK);
    }


}
