package com.mercadolibre.cardealership.repository;

import com.mercadolibre.cardealership.entity.VehicleEntity;

import java.util.List;

public interface VehicleRepository extends DAORepository<VehicleEntity> {
    public List<VehicleEntity> findVehiclesByPrice(String price);
    public List<VehicleEntity> findVehiclesByManufacturingDate(String manufacturingDate);
}
