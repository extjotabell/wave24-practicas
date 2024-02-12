package org.example.hqlvehiculosasegurados.controller;

import org.example.hqlvehiculosasegurados.dto.PatenteDto;
import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.VehiculoDto;
import org.example.hqlvehiculosasegurados.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/vehiculos")
    public ResponseEntity<VehiculoDto> saveVehiculo(@RequestBody VehiculoDto vehiculoDto){
        return new ResponseEntity<>(vehiculoService.save(vehiculoDto), HttpStatus.OK);
    }

    @GetMapping("/vehiculos/all")
    public ResponseEntity<List<VehiculoDto>> getAllVehiculos(){
        return new ResponseEntity<>(vehiculoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/vehiculos/{id}")
    public ResponseEntity<VehiculoDto> getVehiculosById(@PathVariable Long id){
        return new ResponseEntity<>(vehiculoService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/vehiculos/{id}")
    public ResponseEntity<ResponseDto> updateVehiculoById(@PathVariable Long id, @RequestBody VehiculoDto vehiculoDto){
        return new ResponseEntity<>(vehiculoService.update(id, vehiculoDto), HttpStatus.OK);
    }

    @DeleteMapping("/vehiculos/{id}")
    public ResponseEntity<ResponseDto> deleteVehiculoById(@PathVariable Long id){
        return new ResponseEntity<>(vehiculoService.deleteById(id), HttpStatus.OK);
    }



    @GetMapping("/patentes")
    public ResponseEntity<PatenteDto> getAllPatentes(){
        return new ResponseEntity<>(vehiculoService.getAllPatentes(), HttpStatus.OK);
    }
}
