package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    Vehicle addVehicle(VehicleDto v);
    AverageSpeedDto calculateAverageSpeedByBrand(String brand);
    AverageCapacityDto getAverageCapacity(String brand);

}
