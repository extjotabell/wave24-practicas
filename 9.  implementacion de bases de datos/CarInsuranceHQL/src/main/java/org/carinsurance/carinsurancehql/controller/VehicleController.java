package org.carinsurance.carinsurancehql.controller;

import org.carinsurance.carinsurancehql.dto.PatentDTO;
import org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO;
import org.carinsurance.carinsurancehql.dto.VehiclesDTO;
import org.carinsurance.carinsurancehql.service.interfaces.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehiclesDTO> create(@RequestBody VehiclesDTO vehiclesDTO) {
        return ResponseEntity.ok(vehicleService.save(vehiclesDTO));
    }
    @GetMapping("/all")
    public ResponseEntity<List<VehiclesDTO>> getAll(){
        return ResponseEntity.ok(vehicleService.listOfVehicles());
    }
    @GetMapping("/patents")
    public ResponseEntity<List<PatentDTO>> getPatents(){
        return ResponseEntity.ok(vehicleService.listOfPatents());
    }
    @GetMapping("/patentsAndBrands")
    public ResponseEntity<List<SummaryVehiclesDTO>> getPatentsAndBrands(){
        return ResponseEntity.ok(vehicleService.listOfPatentsAndBrands());
    }
    @GetMapping("/patentsWithWheelsAndYear")
    public ResponseEntity<List<SummaryVehiclesDTO>> getPatentsWithWheelsAndYear(){
        return ResponseEntity.ok(vehicleService.listOfPatentsWithWheelsAndYear());
    }
    @GetMapping("/idAndBrandAndModelByHigherPriceToOneHundredThousand")
    public ResponseEntity<List<SummaryVehiclesDTO>> getIdAndBrandAndModelByHigherPriceToOneHundredThousand(){
        return ResponseEntity.ok(vehicleService.listOfIdAndBrandAndModelByHigherPriceToOneHundredThousand());
    }
    @GetMapping("/idAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss")
    public ResponseEntity<List<SummaryVehiclesDTO>> getIdAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss(){
        return ResponseEntity.ok(vehicleService.listOfIdAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss());
    }

}
