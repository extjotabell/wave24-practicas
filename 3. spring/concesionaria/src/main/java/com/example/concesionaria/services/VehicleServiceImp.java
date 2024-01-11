package com.example.concesionaria.services;

import com.example.concesionaria.dtos.NewVehicle;
import com.example.concesionaria.dtos.VehicleDTO;
import com.example.concesionaria.entities.Vehicle;
import com.example.concesionaria.exceptions.NotFoundException;
import com.example.concesionaria.repositories.VehicleRepository;
import com.example.concesionaria.services.interfaces.VehicleServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImp implements VehicleServiceInt {

    private final VehicleRepository vehicleRepository;

    @Override
    public NewVehicle save(NewVehicle newVehicle) {
        Vehicle vehicle = new Vehicle(newVehicle);

        vehicleRepository.save(vehicle);

        return new NewVehicle(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners(),
                vehicle.getServices()
        );
    }

    @Override
    public List<VehicleDTO> findAll() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<VehicleDTO> vehicleDTOList = vehicleList.stream()
                .map(vehicle -> new VehicleDTO(
                        vehicle.getId(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getManufacturingDate(),
                        vehicle.getNumberOfKilometers(),
                        vehicle.getDoors(),
                        vehicle.getPrice(),
                        vehicle.getCurrency(),
                        vehicle.getCountOfOwners()
                )).toList();

        return vehicleDTOList;
    }

    @Override
    public List<VehicleDTO> findVehiclesByDate(String since, String to) {
        List<VehicleDTO> vehicleDTOList = findAll();

        return vehicleDTOList.stream()
                .filter(
                        vehicle -> vehicle.manufacturingDate().isAfter(LocalDate.parse(since)) &&
                                vehicle.manufacturingDate().isBefore(LocalDate.parse(to))
                )
                .toList();
    }

    @Override
    public List<VehicleDTO> findVehiclesByPrice(Double since, Double to) {
        List<VehicleDTO> vehicleDTOList = findAll();

        return vehicleDTOList.stream()
                .filter(
                        vehicle -> vehicle.price() > since &&
                                vehicle.price() < to
                )
                .toList();
    }

    @Override
    public NewVehicle findVehicleById(Long id) throws NotFoundException {
        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null){
            throw new NotFoundException("Vehicle not found");
        };

        return new NewVehicle(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners(),
                vehicle.getServices()
        );
    }
}
