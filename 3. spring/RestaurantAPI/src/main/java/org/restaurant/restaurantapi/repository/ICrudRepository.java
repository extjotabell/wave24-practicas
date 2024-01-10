package org.restaurant.restaurantapi.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T> {
    T save(T entity);
    T deleteByName(String name);
    T update(T entity);
    Optional<T> findByName(String name);
    List<T> findAll();
}
