package org.example.ejercicios.repository;

import java.util.List;

public interface ICrudRepository<ENTITY> {
    ENTITY save();
    ENTITY update();
    Boolean delete();
    List<ENTITY> findAll();
    ENTITY findById();
}