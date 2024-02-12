package org.example.hqlvehiculosasegurados.service;

import org.example.hqlvehiculosasegurados.dto.ResponseDto;
import org.example.hqlvehiculosasegurados.dto.VehiculoDto;

import java.util.List;

public interface ICrudService <Entity, ID>{
    Entity save(Entity entity);

    List<Entity> getAll();

    Entity getById(ID id);


    ResponseDto update(ID id, Entity entity);
    ResponseDto deleteById(ID id);
}
