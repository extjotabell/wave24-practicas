package org.socialmeli.be_java_hisp_w24_g04.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T> {
    T save(T entity);
    T remove(Integer id);
    Optional<T> get(Integer id);
    List<T> findAll();
    T update(T entity);
}
