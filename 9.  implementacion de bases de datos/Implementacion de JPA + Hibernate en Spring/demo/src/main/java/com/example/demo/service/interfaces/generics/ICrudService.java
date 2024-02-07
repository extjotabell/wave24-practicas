package com.example.demo.service.interfaces.generics;

import com.example.demo.dto.MessageDto;

import java.util.List;

public interface ICrudService <T,ID> {
    T save(T entity);
    T getById(ID id);
    List<T> getAll();
    MessageDto deleteById(ID id);
}
