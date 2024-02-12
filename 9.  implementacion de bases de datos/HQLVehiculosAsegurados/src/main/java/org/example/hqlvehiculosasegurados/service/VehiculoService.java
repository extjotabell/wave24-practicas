package org.example.hqlvehiculosasegurados.service;

import org.example.hqlvehiculosasegurados.dto.PatenteDto;
import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.VehiculoDto;
import org.example.hqlvehiculosasegurados.entity.Vehiculo;
import org.example.hqlvehiculosasegurados.mapper.Mapper;
import org.example.hqlvehiculosasegurados.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;

    private final Mapper mapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository, Mapper mapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = mapper;
    }

    @Override
    public VehiculoDto save(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = mapper.convertDtoToVehiculo(vehiculoDto);
        vehiculoRepository.save(vehiculo);
        return mapper.convertVehiculoToDto(vehiculo);
    }

    @Override
    public List<VehiculoDto> getAll() {
        return mapper.convertListToListDto(vehiculoRepository.findAll());
    }

    @Override
    public VehiculoDto getById(Long id) {
        return mapper.convertVehiculoToDto(vehiculoRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseDto update(Long id, VehiculoDto vehiculoDto) {
        Vehiculo vehiculoToUpdate = vehiculoRepository.getById(id);
        vehiculoToUpdate.setId(vehiculoDto.id());
        vehiculoToUpdate.setPatente(vehiculoDto.patente());
        vehiculoToUpdate.setMarca(vehiculoDto.marca());
        vehiculoToUpdate.setModelo(vehiculoDto.modelo());
        vehiculoToUpdate.setAnioFabricacion(vehiculoDto.anioFabricacion());
        vehiculoToUpdate.setCantidadDeRuedas(vehiculoDto.cantidadDeRuedas());
        vehiculoToUpdate.setSiniestros(mapper.convertListDtoToListSiniestro(vehiculoDto.siniestros()));
        return new ResponseDto("Vehiculo actualizado");
    }

    @Override
    public ResponseDto deleteById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.getById(id);
        vehiculoRepository.delete(vehiculo);
        return new ResponseDto("Vehiculo eliminado.");
    }

    public PatenteDto getAllPatentes(){
        List<String> patenteDtoList = vehiculoRepository.findAll().stream()
                .map(vehiculo -> vehiculo.getPatente())
                .collect(Collectors.toList());
        return new PatenteDto(patenteDtoList);
    }
}
