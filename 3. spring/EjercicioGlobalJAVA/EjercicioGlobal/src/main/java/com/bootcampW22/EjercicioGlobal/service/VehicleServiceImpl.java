package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InvalidVehicleException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistException;
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
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto create(Vehicle vehicle) {

        try {
            if (vehicle.getBrand().isEmpty()
                    || vehicle.getModel().isEmpty()
                    || vehicle.getRegistration().isEmpty()
                    || vehicle.getColor().isEmpty()
                    || vehicle.getYear() == 0
                    || vehicle.getMax_speed().isEmpty()
                    || vehicle.getPassengers() == 0
                    || vehicle.getFuel_type().isEmpty()
                    || vehicle.getTransmission().isEmpty()
                    || vehicle.getLength() == 0
                    || vehicle.getWidth() == 0
                    || vehicle.getWeight() == 0) {
                throw new InvalidVehicleException("El vehiculo ingresado está incompleto.");
            }
        } catch(Exception e) {
            throw new InvalidVehicleException("El vehiculo ingresado está incompleto.");
        }

        if (vehicleRepository.findAll().stream().anyMatch(vehicle1 -> vehicle1.getId().equals(vehicle.getId()))){
            throw new VehicleAlreadyExistException("El ID del vehiculo ingresado ya existe.");
        }


        this.vehicleRepository.create(vehicle);
        VehicleDto vehicleDto = convertVehicleToDto(vehicle);
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, Integer year) {
        List<VehicleDto> foundVehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear().equals(year))
                .map(this::convertVehicleToDto)
                .toList();

        if (foundVehicles.isEmpty())
            throw new NotFoundException("No se encontró ningun vehiculo con el color y año ingresados.");
        else
            return foundVehicles;
    }

    @Override
    public List<VehicleDto> searchByBrandAndYear(String brand, Integer start_year, Integer end_year) {

        List<VehicleDto> foundVehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear() >= start_year && vehicle.getYear() <= end_year)
                .map(this::convertVehicleToDto)
                .toList();

        if(foundVehicles.isEmpty())
            throw new NotFoundException("No se encontró ningun vehiculo con la marca y años ingresados.");
        else
            return foundVehicles;
    }

    @Override
    public Double getAverageSpeedByBrand(String brand) {

        List<Vehicle> brandVehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();

        if(brandVehicles.isEmpty())
            throw new NotFoundException("No se encontró ningun vehiculo con la marca ingresada.");
        else {
            return brandVehicles.stream()
                    .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                    .average()
                    .getAsDouble();
        }
    }

    @Override
    public List<VehicleDto> createBatch(List<Vehicle> vehicles) {

        try {
            vehicles.stream().forEach(vehicle -> {
                if (vehicle.getBrand().isEmpty()
                        || vehicle.getModel().isEmpty()
                        || vehicle.getRegistration().isEmpty()
                        || vehicle.getColor().isEmpty()
                        || vehicle.getYear() == 0
                        || vehicle.getMax_speed().isEmpty()
                        || vehicle.getPassengers() == 0
                        || vehicle.getFuel_type().isEmpty()
                        || vehicle.getTransmission().isEmpty()
                        || vehicle.getLength() == 0
                        || vehicle.getWidth() == 0
                        || vehicle.getWeight() == 0) {
                    throw new InvalidVehicleException("Datos de algún vehículo mal formados o incompletos.");
                }
            });
        } catch(Exception e) {;
            throw new InvalidVehicleException("Datos de algún vehículo mal formados o incompletos.");
        }

        vehicles.stream().forEach(vehicle -> {
            if (vehicleRepository.findAll().stream().anyMatch(vehicle1 -> vehicle1.getId().equals(vehicle.getId()))){
                throw new VehicleAlreadyExistException("El ID del vehiculo ingresado ya existe.");
            }
        });

        vehicles.stream()
                .forEach(vehicle -> {
                    this.create(vehicle);
                });

        List<VehicleDto> vehicleDtoList = vehicles.stream()
                .map(this::convertVehicleToDto)
                .toList();

        return vehicleDtoList;
    }

    @Override
    public VehicleDto updateSpeed(Long id, Vehicle vehicle) {

        try {
            if (vehicle.getMax_speed().isEmpty()) {
                throw new InvalidVehicleException("Velocidad mal formada o fuera de rango.");
            } else {
                if (vehicleRepository.findAll().stream().anyMatch(vehicle1 -> vehicle1.getId().equals(id))){
                    vehicleRepository.update(vehicle);
                    return convertVehicleToDto(vehicle);
                } else {
                    throw new NotFoundException("No se encontró ningun vehiculo con el ID ingresado.");
                }
            }
        } catch (Exception e) {
            throw new InvalidVehicleException("Velocidad mal formada o fuera de rango.");
        }
    }

    @Override
    public void deleteVehicle(Long id) {
        if (vehicleRepository.findAll().stream().anyMatch(vehicle -> vehicle.getId().equals(id))){
            vehicleRepository.delete(id);
        } else {
            throw new NotFoundException("No se encontró ningun vehiculo con el ID ingresado.");
        }
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
