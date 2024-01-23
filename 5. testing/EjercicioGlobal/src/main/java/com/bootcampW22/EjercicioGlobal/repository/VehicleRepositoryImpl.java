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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl(){
        try {
            loadDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public List<Vehicle> bulkCreate(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
        return vehicles;
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return listOfVehicles.stream().filter(vehicle -> Objects.equals(vehicle.getId(), id)).findFirst();
    }

    @Override
    public List<Vehicle> findByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth) {
        return listOfVehicles.stream()
                .filter(vehicle ->
                        (vehicle.getLength() >= minLength && vehicle.getLength() <= maxLength) &&
                        (vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                ).toList();
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        listOfVehicles = listOfVehicles.stream().map(vehicleMap -> {
            if(Objects.equals(vehicle.getId(), vehicleMap.getId())){
                return vehicle;
            }
            return vehicleMap;
        }).toList();

        return vehicle;
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
