package org.example.hqlvehiculosasegurados.service;

import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.VehiculoDto;
import org.example.hqlvehiculosasegurados.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoDto save(VehiculoDto vehiculoDto) {
        return null;
    }

    @Override
    public List<VehiculoDto> getAll() {
        return null;
    }

    @Override
    public VehiculoDto getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseDto update(Long aLong, VehiculoDto vehiculoDto) {
        return null;
    }

    @Override
    public ResponseDto deleteById(Long aLong) {
        return null;
    }
}
