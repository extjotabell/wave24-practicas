package org.example.hqlvehiculosasegurados.mapper;

import org.example.hqlvehiculosasegurados.dto.VehiculoDto;
import org.example.hqlvehiculosasegurados.entity.Vehiculo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public Vehiculo convertDtoToVehiculo(VehiculoDto vehiculoDto){
        return new Vehiculo(
                vehiculoDto.id(),
                vehiculoDto.patente(),
                vehiculoDto.marca(),
                vehiculoDto.modelo(),
                vehiculoDto.anioFabricacion(),
                vehiculoDto.cantidadDeRuedas(),
                vehiculoDto.siniestros()
        );
    }

    public  VehiculoDto convertVehiculoToDto(Vehiculo vehiculo){
        return new VehiculoDto(
                vehiculo.getId(),
                vehiculo.getPatente(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnioFabricacion(),
                vehiculo.getCantidadDeRuedas(),
                vehiculo.getSiniestros()
        );
    }

    public List<VehiculoDto> convertListToListDto(List<Vehiculo> vehiculoList){
        return vehiculoList.stream().map(this::convertVehiculoToDto).collect(Collectors.toList());
    }
}
