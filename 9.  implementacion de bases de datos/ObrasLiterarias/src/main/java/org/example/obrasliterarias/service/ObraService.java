package org.example.obrasliterarias.service;

import org.example.obrasliterarias.dto.ObraDto;
import org.example.obrasliterarias.dto.ResponseDto;
import org.example.obrasliterarias.entity.Obra;
import org.example.obrasliterarias.mapper.Mapper;
import org.example.obrasliterarias.repository.IObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService implements IObraService{

    private final IObraRepository obraRepository;

    private final Mapper mapper;

    public ObraService(IObraRepository obraRepository, Mapper mapper) {
        this.obraRepository = obraRepository;
        this.mapper = mapper;
    }

    @Override
    public ObraDto save(ObraDto obraDto) {
        return mapper.convertEntityToDto(obraRepository.save(mapper.convertDtoToEntity(obraDto)));
    }

    @Override
    public List<ObraDto> getAll() {
        return null;
    }

    @Override
    public ObraDto getById(Long id) {
        return mapper.convertEntityToDto(obraRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseDto updateById(Long id, ObraDto obraDto) {
        return null;
    }

    @Override
    public ResponseDto deleteById(Long id) {
        return null;
    }

    @Override
    public List<Obra> getByAutor(String autor) {
        return obraRepository.findByAutor(autor);
    }

    @Override
    public List<Obra> getByNombre(String nombre) {
        return obraRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Obra> getByCantidadPaginas(Integer cantidadPaginas) {
        return obraRepository.findByCantidadPaginasGreaterThan(cantidadPaginas);
    }

    @Override
    public List<Obra> getByEditorial(String editorial) {
        return obraRepository.findByEditorial(editorial);
    }
}
