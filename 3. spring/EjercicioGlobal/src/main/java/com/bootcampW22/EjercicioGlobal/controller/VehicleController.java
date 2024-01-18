package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
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

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByFuelType(type), HttpStatus.OK);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<Vehicle>> getVehiclesByColorAndYear(
            @PathVariable String color,
            @PathVariable int year
    ) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByColorAndYear(color, year);
        if (!vehicles.isEmpty()) {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //public boolean addVehicle(@RequestBody Vehicle vehicle){
    //    return vehiclesService.addCar(vehicle);
    //}

    //@PostMapping
    //public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
    //    try {
    //        Vehicle addedVehicle = vehicleService.addVehicle(vehicle);
    //        return new ResponseEntity<>(addedVehicle, HttpStatus.CREATED);
    //    } catch (Exception e) {
    //        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //    }
    //}
}
