package org.example.hqlvehiculosasegurados.service;

import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.SiniestroDto;
import org.example.hqlvehiculosasegurados.entity.Siniestro;
import org.example.hqlvehiculosasegurados.mapper.Mapper;
import org.example.hqlvehiculosasegurados.repository.ISiniestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService{

    private final ISiniestroRepository siniestroRepository;

    private final Mapper mapper;

    public SiniestroService(ISiniestroRepository siniestroRepository, Mapper mapper) {
        this.siniestroRepository = siniestroRepository;
        this.mapper = mapper;
    }

    @Override
    public SiniestroDto save(SiniestroDto siniestroDto) {
        Siniestro siniestro = mapper.convertDtoToSiniestro(siniestroDto);
        siniestroRepository.save(siniestro);
        return mapper.convertSiniestroToDto(siniestro);
    }

    @Override
    public List<SiniestroDto> getAll() {
        return mapper.convertListSiniestroToListDto(siniestroRepository.findAll());
    }

    @Override
    public SiniestroDto getById(Long id) {
        return mapper.convertSiniestroToDto(siniestroRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseDto update(Long id, SiniestroDto siniestroDto) {
        Siniestro siniestroToUpdate = siniestroRepository.getById(id);
        siniestroToUpdate.setId(siniestroDto.id());
        siniestroToUpdate.setFechaSiniestro(siniestroDto.fechaSiniestro());
        siniestroToUpdate.setPerdidaEconomica(siniestroDto.perdidaEconomica());
        return new ResponseDto("Siniestro modificado");
    }

    @Override
    public ResponseDto deleteById(Long id) {
        Siniestro siniestro = siniestroRepository.getById(id);
        siniestroRepository.delete(siniestro);
        return new ResponseDto("Siniestro eliminado");
    }
}
