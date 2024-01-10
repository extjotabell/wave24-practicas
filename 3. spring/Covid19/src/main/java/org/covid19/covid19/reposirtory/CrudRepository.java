package org.covid19.covid19.reposirtory;

import java.util.List;

public interface CrudRepository<T>{
    List<T> findAll();
    T findById(Integer id);
    T save(T entity);
    List<T> update(T entity);
    T deleteById(Integer id);
}
