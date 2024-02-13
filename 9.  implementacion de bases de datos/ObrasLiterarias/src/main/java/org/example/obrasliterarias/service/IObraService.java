package org.example.obrasliterarias.service;

import org.example.obrasliterarias.dto.ObraDto;
import org.example.obrasliterarias.dto.ResponseDto;
import org.example.obrasliterarias.entity.Obra;

import java.util.List;

public interface IObraService {

    ObraDto save(ObraDto obraDto);

    List<ObraDto> getAll();

    ObraDto getById(Long id);

    ResponseDto updateById(Long id, ObraDto obraDto);

    ResponseDto deleteById(Long id);

    List<Obra> getByAutor(String autor);

    List<Obra> getByNombre(String nombre);

    List<Obra> getByCantidadPaginas(Integer cantidadPaginas);

    List<Obra> getByEditorial(String editorial);
}
