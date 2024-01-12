package com.contarcalorias.spring.repository;

import java.util.ArrayList;
import java.util.Optional;

public interface ICrudRepository<T> {

    T save(T entity);

    T update(T entity);

    Boolean deleteById(Integer id);

    Optional<T> findById(Integer id);

    ArrayList<T> findAll();

}