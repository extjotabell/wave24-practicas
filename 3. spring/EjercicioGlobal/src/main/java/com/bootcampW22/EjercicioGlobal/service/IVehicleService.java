package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    List<VehicleDto> getVehiclesByBrandBetweenYears(String brand, Integer startYear, Integer endYear);
}
