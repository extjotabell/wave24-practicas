package com.practice.testers.service.interfaces.generics;

import com.practice.testers.dto.MessageDTO;

import java.util.List;

public interface ICrudService<T, I> {
    MessageDTO save(T entity);

    MessageDTO getById(I id);

    MessageDTO getAll();

    MessageDTO deleteById(I id);

    MessageDTO updateById(I id,T entity);
}
