package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.DuplicateException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{
    @Override
    public AverageSpeedDto calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(brand);
        if (vehiclesByBrand.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos de esta marca");
        Integer speed=0;
        for(Vehicle vehicle: vehiclesByBrand){
            speed+=Integer.parseInt(vehicle.getMax_speed());
        }
        return new AverageSpeedDto(speed/vehiclesByBrand.size());
    }

    IVehicleRepository vehicleRepository;
    @Override
    public AverageCapacityDto getAverageCapacity(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(brand);
        Integer capacity = 0;
        if(vehiclesByBrand.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos de esta marca");
        for(Vehicle vehicle: vehiclesByBrand){
            capacity += vehicle.getPassengers();
        }
        return new AverageCapacityDto(capacity/vehiclesByBrand.size());
    }
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
    public Vehicle addVehicle(VehicleDto v) {
        if(!Objects.isNull(vehicleRepository.findById(v.id())))
            throw new DuplicateException("Identificador del Vehiculo ya existente");
        else {
            Vehicle vehicle = convertDtoToVehicle(v);
            return vehicleRepository.save(vehicle);
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
    private Vehicle convertDtoToVehicle(VehicleDto v){
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
