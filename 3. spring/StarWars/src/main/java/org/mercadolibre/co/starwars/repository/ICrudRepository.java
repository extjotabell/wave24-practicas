package org.mercadolibre.co.starwars.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T, ID>{
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    T update(T entity);
    Boolean deleteById(ID id);
}
