package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {

        Optional<Vehicle> vehicleUpdate = listOfVehicles.stream().filter(vehicle1 -> vehicle1.getId().equals(vehicle.getId())).findFirst();

        Vehicle vehicle1 = vehicleUpdate.get();
        vehicle1.setBrand(vehicle.getBrand());
        vehicle1.setModel(vehicle.getModel());
        vehicle1.setRegistration(vehicle.getRegistration());
        vehicle1.setColor(vehicle.getColor());
        vehicle1.setYear(vehicle.getYear());
        vehicle1.setMax_speed(vehicle.getMax_speed());
        vehicle1.setPassengers(vehicle.getPassengers());
        vehicle1.setFuel_type(vehicle.getFuel_type());
        vehicle1.setTransmission(vehicle.getTransmission());
        vehicle1.setLength(vehicle.getLength());
        vehicle1.setWidth(vehicle.getWidth());
        vehicle1.setWeight(vehicle.getWeight());

        return vehicle;
    }

    @Override
    public void delete(Long id) {
        listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
