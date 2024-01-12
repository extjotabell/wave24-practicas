package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.CreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    List<CreateVehicleDTO> createVehiclesBatch(List<VehicleDto> vehiclesDTO);

    List<VehicleDto> findByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth);

    VehicleDto updateFuel(VehicleDto vehicleDto);
}
