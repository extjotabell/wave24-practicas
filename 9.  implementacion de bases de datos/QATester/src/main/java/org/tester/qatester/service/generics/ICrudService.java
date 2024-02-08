package org.tester.qatester.service.generics;

import org.tester.qatester.dto.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID>{

    T save(T entity);
    T update(T entity, Long id);
    T findById(Long id);
    List<T> findAll();
    MessageDTO delete(Long id);
}
