package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = getAllVehicles();
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList;
    }
    public List<Vehicle> getAllVehiclesByBrand(String brand){
        List<Vehicle> vehicleListByBrand = vehicleRepository.findAll();
        vehicleListByBrand = vehicleListByBrand.stream().filter(v->v.getBrand().equals(brand)).toList();
        if(vehicleListByBrand.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema de la marca especificada.");
        }
        return vehicleListByBrand;
    }
    @Override
    public Double getAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleListByBrand = getAllVehiclesByBrand(brand);

        return
                vehicleListByBrand.stream()
                        .mapToDouble(Vehicle::getMax_speed)
                        .average().getAsDouble();
    }

    private VehicleDto convertVehicleToDto(Vehicle v){
        return new VehicleDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getRegistration(),
                v.getColor(),
                v.getYear(),
                v.getMax_speed(),
                v.getPassengers(),
                v.getFuel_type(),
                v.getTransmission(),
                v.getLength(),
                v.getWidth(),
                v.getWeight());
    }
}
