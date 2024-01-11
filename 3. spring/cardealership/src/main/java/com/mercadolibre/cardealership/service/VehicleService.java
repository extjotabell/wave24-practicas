package com.mercadolibre.cardealership.service;

import com.mercadolibre.cardealership.dto.CreateVechileReponseDTO;
import com.mercadolibre.cardealership.dto.ServicesDTO;
import com.mercadolibre.cardealership.dto.VehicleDTO;
import com.mercadolibre.cardealership.entity.ServiceEntity;
import com.mercadolibre.cardealership.entity.VehicleEntity;
import com.mercadolibre.cardealership.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public CreateVechileReponseDTO createVehicle(VehicleDTO createVehicleDTO){
        this.vehicleRepository.create(
                new VehicleEntity(
                        UUID.randomUUID().toString(),
                        createVehicleDTO.brand(),
                        createVehicleDTO.model(),
                        createVehicleDTO.manufacturingDate(),
                        createVehicleDTO.numberOfKilometers(),
                        createVehicleDTO.doors(),
                        createVehicleDTO.price(),
                        createVehicleDTO.currency(),
                        createVehicleDTO.services().stream().map(
                                servicesDTO -> new ServiceEntity(
                                        servicesDTO.date(),
                                        servicesDTO.kilometers(),
                                        servicesDTO.descriptions()
                                )
                        ).toList(),
                        createVehicleDTO.countOfOwners()
                )
        );
        return new CreateVechileReponseDTO(Boolean.TRUE);
    }

    public List<VehicleDTO> getAllsVehicles(){
        return this.vehicleRepository.findAll()
                .stream()
                .map(VehicleService::convertVehiclesEntityToVehicleDTO)
                .collect(Collectors.toList());
    }

    public List<VehicleDTO> getVehiclesByManufacturingDate(String manufacturingDate){
        return this.vehicleRepository.findVehiclesByManufacturingDate(manufacturingDate)
                .stream()
                .map(VehicleService::convertVehiclesEntityToVehicleDTO)
                .collect(Collectors.toList());
    }

    public List<VehicleDTO> getVechiclesByPrices(String price){
        return this.vehicleRepository.findVehiclesByPrice(price)
                .stream()
                .map(VehicleService::convertVehiclesEntityToVehicleDTO)
                .collect(Collectors.toList());
    }

    public VehicleDTO getVehicleById(String id){
        var vehicleFinded = this.vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
        return VehicleService.convertVehiclesEntityToVehicleDTO(vehicleFinded);
    }

    private static VehicleDTO convertVehiclesEntityToVehicleDTO(VehicleEntity vehicleEntity){
        return new VehicleDTO(
                vehicleEntity.getBrand(),
                vehicleEntity.getModel(),
                vehicleEntity.getManufacturingDate(),
                vehicleEntity.getNumberOfKilometers(),
                vehicleEntity.getDoors(),
                vehicleEntity.getPrice(),
                vehicleEntity.getCurrency(),
                vehicleEntity.getServices().stream().map(
                        serviceEntity -> new ServicesDTO(
                                serviceEntity.getDate(),
                                serviceEntity.getKilometers(),
                                serviceEntity.getDescriptions()
                        )
                ).toList(),
                vehicleEntity.getCountOfOwners()
        );
    }
}
