package org.example.obrasliterarias.mapper;

import org.example.obrasliterarias.dto.ObraDto;
import org.example.obrasliterarias.entity.Obra;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Obra convertDtoToEntity(ObraDto obraDto){
        return new Obra(
                obraDto.id(),
                obraDto.nombre(),
                obraDto.autor(),
                obraDto.cantidadPaginas(),
                obraDto.editorial(),
                obraDto.anioPublicacion()
        );
    }

    public ObraDto convertEntityToDto(Obra obra){
        return new ObraDto(
                obra.getId(),
                obra.getNombre(),
                obra.getAutor(),
                obra.getCantidadPaginas(),
                obra.getEditorial(),
                obra.getAnioPublicacion()
        );
    }

    public List<ObraDto> convertEntityListToDtoList(List<Obra> obraList){
        return obraList.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
