package org.mercadolibre.co.calorias.repository;

import java.util.Optional;

public interface ICrudRepository <T, ID>{

    T create(T t);
    T update(T t);
    boolean delete(ID id);
    T findById(ID id);
    Optional<T> findAll();

}
