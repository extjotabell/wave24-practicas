package com.example.blog.repositories.interfaces;

import java.util.List;

public interface CrudRepository<T> {

        T findById(Long id);

        T save(T t);

        List<T> findAll();

}
