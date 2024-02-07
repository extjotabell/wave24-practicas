package com.practice.jewerly.service.interfaces.generics;

import com.practice.jewerly.dto.MessageDto;

import java.util.List;

public interface ICrudService <T, ID> {
    MessageDto save(T entity);

    T getById(ID id);

    List<T> getAll();

    MessageDto deleteById(ID id);

    MessageDto updateById(ID id,T entity);
}
