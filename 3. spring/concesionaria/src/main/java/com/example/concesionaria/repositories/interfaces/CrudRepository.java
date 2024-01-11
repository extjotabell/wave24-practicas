package com.example.concesionaria.repositories.interfaces;

import java.util.List;

public interface CrudRepository<T> {

    T save(T t);

    T findById(Long id);

    List<T> findAll();

}
