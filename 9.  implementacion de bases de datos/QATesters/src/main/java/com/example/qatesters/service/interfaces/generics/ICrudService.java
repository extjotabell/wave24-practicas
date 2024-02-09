package com.example.qatesters.service.interfaces.generics;

import com.example.qatesters.dto.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID> {
    T saveEntity(T personDTO);

    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
