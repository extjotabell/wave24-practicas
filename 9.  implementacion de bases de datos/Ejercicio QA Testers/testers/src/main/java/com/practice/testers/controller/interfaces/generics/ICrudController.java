package com.practice.testers.controller.interfaces.generics;

import org.springframework.http.ResponseEntity;

public interface ICrudController<T, E> {
    ResponseEntity<T> create(E entity);
    ResponseEntity<T> getAll();
    ResponseEntity<T> getById(Long id);
    ResponseEntity<T> updateById(Long id, E entity);
    ResponseEntity<T> deleteById(Long id);
}
