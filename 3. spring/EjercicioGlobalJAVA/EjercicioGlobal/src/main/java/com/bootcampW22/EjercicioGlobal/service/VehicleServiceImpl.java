package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository; //implementar inyeccion de capa repository
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateSpeed(Integer id, String speed) {

        //validar valeocidad
        if((speed == "") || speed.contains("-") || (speed.trim().length() == 0) ) {
            throw new BadRequest("Request: Velocidad mal formada o fuera de rango.");
        }

        //actualizar velocidad
        var vehicule = vehicleRepository.updateSpeed(id, speed);

        //validar la actualizacion
        if(vehicule.isEmpty()){
            throw new NotFoundException("No se encontró el vehiculo");
        }return true;
    }

    @Override
    public VehicleDto getVehicle(Integer id) {
        var vehicle = vehicleRepository.getVehicle(id);

        if(vehicle.isEmpty()){
            throw new NotFoundException("No se encontró el vehiculo");
        }else{
            return convertVehicleToDto(vehicle.get());}
    }

    @Override
    public Boolean createVehicule(Vehicle vehicle) {
       var v =  vehicleRepository.createVehicle(vehicle);
        System.out.println(v.toString());
       if (v != null){
           return true;
       }else{
           throw new BadRequest("Datos del vehículo mal formados o incompletos.");
       }

    }

    @Override
    public List<VehicleDto> filterbyColorYear(String color, Integer year) {
        List<Vehicle> result = vehicleRepository.filterbyColorYear(color, year);
        if(result.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return result.stream().map(this::convertVehicleToDto).collect(Collectors.toList());

    }

    @Override
    public List<VehicleDto> filterbyBrandYear(String brand, Integer yearInit, Integer yearEnd) {
        var result = vehicleRepository.filterbyBrandYear(brand, yearInit,yearEnd);

        if(result.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return result.stream().map(this::convertVehicleToDto).collect(Collectors.toList());
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
