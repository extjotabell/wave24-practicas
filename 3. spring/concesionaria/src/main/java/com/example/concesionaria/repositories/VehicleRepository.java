package com.example.concesionaria.repositories;

import com.example.concesionaria.entities.Vehicle;
import com.example.concesionaria.repositories.interfaces.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements CrudRepository<Vehicle> {

    private static List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(vehicle.getNewID());
        vehicleList.add(vehicle);

        return vehicle;
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }
}
