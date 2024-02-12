package org.example.hqlvehiculosasegurados.mapper;

import org.example.hqlvehiculosasegurados.dto.SiniestroDto;
import org.example.hqlvehiculosasegurados.dto.VehiculoDto;
import org.example.hqlvehiculosasegurados.entity.Siniestro;
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
                vehiculoDto.cantidadDeRuedas()
        );
    }

    public  VehiculoDto convertVehiculoToDto(Vehiculo vehiculo){
        return new VehiculoDto(
                vehiculo.getId(),
                vehiculo.getPatente(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnioFabricacion(),
                vehiculo.getCantidadDeRuedas()
                //convertListSiniestroToListDto(vehiculo.getSiniestros())
        );
    }

    public List<VehiculoDto> convertListToListDto(List<Vehiculo> vehiculoList){
        return vehiculoList.stream().map(this::convertVehiculoToDto).collect(Collectors.toList());
    }

    public Siniestro convertDtoToSiniestro(SiniestroDto siniestroDto){
        return new Siniestro(
                siniestroDto.id(),
                siniestroDto.fechaSiniestro(),
                siniestroDto.perdidaEconomica()
        );
    }

    public SiniestroDto convertSiniestroToDto(Siniestro siniestro){
        return new SiniestroDto(
                siniestro.getId(),
                siniestro.getFechaSiniestro(),
                siniestro.getPerdidaEconomica(),
                siniestro.getId()
        );
    }

    public List<SiniestroDto> convertListSiniestroToListDto(List<Siniestro> siniestroList){
        return siniestroList.stream().map(this::convertSiniestroToDto).collect(Collectors.toList());
    }

    public List<Siniestro> convertListDtoToListSiniestro(List<SiniestroDto> siniestroDtoList){
        return siniestroDtoList.stream().map(this::convertDtoToSiniestro).collect(Collectors.toList());
    }
}
