package org.example.hqlvehiculosasegurados.service;

import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.SiniestroDto;
import org.example.hqlvehiculosasegurados.repository.ISiniestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService{

    private final ISiniestroRepository siniestroRepository;

    public SiniestroService(ISiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public SiniestroDto save(SiniestroDto siniestroDto) {
        return null;
    }

    @Override
    public List<SiniestroDto> getAll() {
        return null;
    }

    @Override
    public SiniestroDto getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseDto update(Long aLong, SiniestroDto siniestroDto) {
        return null;
    }

    @Override
    public ResponseDto deleteById(Long aLong) {
        return null;
    }
}
