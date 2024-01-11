package org.linktraker.linktrackerapi.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T> {
    T save(T entity);
    T remove(Integer id);
    Optional<T> findById(Integer id);
    List<T> findAll();
    T update(T entity);
}
