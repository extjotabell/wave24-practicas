package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.Conflict;
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
    public Optional<Vehicle> updateSpeed(Integer id, String speed) {
        //buscar el vehiculo
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals((long)id))
                .peek(vehicle -> {vehicle.setMax_speed(speed); System.out.println("Actualizado");})
                .findFirst();
    }




    @Override
    public Optional<Vehicle> getVehicle(Integer id) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getId().equals((long)id)).findFirst();
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        boolean b = listOfVehicles.stream().anyMatch(v -> v.getId().equals((long) vehicle.getId()));
        if(b){
            throw new Conflict("Identificador del vehículo ya existente.");
        }else{
            listOfVehicles.add(vehicle);
            System.out.println("Agregado");
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> filterbyColorYear(String color, Integer year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().toUpperCase().equals(color.toUpperCase()) && vehicle.getYear().equals(year))
                .toList();
    }

    @Override
    public List<Vehicle> filterbyBrandYear(String brand, Integer yearInit, Integer yearEnd) {

        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear() >= yearInit && vehicle.getYear() <= yearEnd)
                .toList();
    }


    //metodo del enpoint
    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;
        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});
        listOfVehicles = vehicles;
    }
}
