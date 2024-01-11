package com.mercadolibre.cardealership.repository;

import com.mercadolibre.cardealership.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    private List<VehicleEntity> vehicles;

    public VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public VehicleEntity create(VehicleEntity vehicleEntity) {
        this.vehicles.add(vehicleEntity);
        return vehicleEntity;
    }

    @Override
    public Optional<VehicleEntity> findById(String id) {
        return this.vehicles.stream().filter(vehicleEntity -> vehicleEntity.getId().equals(id)).findFirst();
    }

    @Override
    public List<VehicleEntity> findAll() {
        return this.vehicles;
    }

    @Override
    public List<VehicleEntity> findVehiclesByPrice(String price) {
        return this.vehicles.stream().filter(vehicleEntity -> vehicleEntity.getPrice().equals(price)).toList();
    }

    @Override
    public List<VehicleEntity> findVehiclesByManufacturingDate(String manufacturingDate) {
        return this.vehicles.stream().filter(vehicleEntity -> vehicleEntity.getManufacturingDate().equals(manufacturingDate)).toList();
    }
}
