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

    private ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId((long) listOfVehicles.size());

        if(this.listOfVehicles.add(vehicle)){
            return vehicle;
        }
        return null;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Vehicle> findByID(Vehicle vehicle) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public ArrayList<Vehicle> findByName(String name) {
        return null;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = (ArrayList<Vehicle>) vehicles;
    }
}
