package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.MessageDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private IVehicleRepository vehicleRepository;

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
                .map(this::convertVehicleDtoToVehicle)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto addVehicle(VehicleDto vehicle) {
        if(vehicle.id() == null || vehicle.brand() == null || vehicle.model() == null || vehicle.registration() == null || vehicle.color() == null || vehicle.year() == null || vehicle.max_speed() == null ||
                vehicle.passengers() == null || vehicle.fuel_type() == null || vehicle.transmission() == null || vehicle.length() == null || vehicle.width() == null || vehicle.weight() == null)
            throw new BadRequestException("El vehiculo no se creo correctamente.");

        Vehicle v = vehicleRepository.findById(vehicle.id());
        if(!Objects.isNull(v))
            throw new ConflictException("El vehiculo ya existe.");

        vehicleRepository.addVehicle(convertVehicleDtoToVehicle(vehicle));
        return new MessageDto("Se agrego correctamente.");
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, Integer year){
        List<Vehicle> vehicles = vehicleRepository.findByColorAndYear(color, year);

        if(vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");

        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle v : vehicles){
            vehicleDtos.add(convertVehicleDtoToVehicle(v));
        }
        return vehicleDtos;
    }

    @Override
    public MessageDto updateSpeed(Integer id, Integer speed){
        Vehicle v = vehicleRepository.updateSpeed(id, speed.toString());

        if(Objects.isNull(v))
            throw new NotFoundException("No se encontró el vehículo.");

        return new MessageDto("Velocidad del vehículo actualizada exitosamente.");
    }

    @Override
    public List<VehicleDto> searchByBrandAndYear(String brand, Integer startYear, Integer endYear){
        List<Vehicle> vehicles = vehicleRepository.findByBrandAndYearsRange(brand, startYear, endYear);

        if(vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");

        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle v : vehicles){
            vehicleDtos.add(convertVehicleDtoToVehicle(v));
        }
        return vehicleDtos;
    }

    @Override
    public MessageDto calculateAveragePassangersByBrand(String brand) {
        return new MessageDto("El promedio de pasajes de la marca " + brand + " es " + vehicleRepository.calculateAveragePassangersByBrand(brand).orElseThrow(() -> {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }));
    }

    @Override
    public MessageDto addVehicles(List<VehicleDto> vehicleDtos) {
        if(vehicleDtos.isEmpty())
            throw new BadRequestException("Datos de algún vehículo mal formados o incompletos.");

        for (VehicleDto vehicle:vehicleDtos) {
            Vehicle v = convertVehicleDtoToVehicle(vehicle);
            if (vehicleRepository.findAll().contains(v))
                throw new ConflictException("Algún vehículo tiene un identificador ya existente.");
        }

        for (VehicleDto vehicle:vehicleDtos) {
            Vehicle v = convertVehicleDtoToVehicle(vehicle);
            vehicleRepository.addVehicle(v);
        }
        return new MessageDto("Vehículos creados exitosamente.");
    }

    private VehicleDto convertVehicleDtoToVehicle(Vehicle v){
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

    private Vehicle convertVehicleDtoToVehicle(VehicleDto v){
        return new Vehicle(
                v.id(),
                v.brand(),
                v.model(),
                v.registration(),
                v.color(),
                v.year(),
                v.max_speed(),
                v.passengers(),
                v.fuel_type(),
                v.transmission(),
                v.length(),
                v.width(),
                v.weight()
        );
    }
}
