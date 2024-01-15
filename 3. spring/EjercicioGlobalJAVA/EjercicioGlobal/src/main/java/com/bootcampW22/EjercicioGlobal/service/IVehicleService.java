package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    Boolean updateSpeed(Integer id ,String  speed);
    VehicleDto getVehicle(Integer id);
    Boolean createVehicule(Vehicle vehicle);

    List<VehicleDto> filterbyColorYear(String color, Integer year);
    List<VehicleDto> filterbyBrandYear(String brand, Integer yearInit, Integer yearEnd);
}
