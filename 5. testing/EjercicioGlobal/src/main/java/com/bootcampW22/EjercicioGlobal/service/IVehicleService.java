package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.MessageDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleWithoutIdDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    MessageDto addVehicle(VehicleDto vehicle);

    List<VehicleDto> searchByColorAndYear(String color, Integer year);

    MessageDto updateSpeed(Integer id, Integer speed);

    List<VehicleDto> searchByBrandAndYear(String brand, Integer startYear, Integer endYear);

    MessageDto calculateAveragePassangersByBrand(String brand);

    MessageDto addVehicles(List<VehicleDto> vehicleDtos);
}
