package com.ejercicio.calculadora_calorias.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<ENTITY> {

    Optional<ENTITY> findByName(String name);
    List<ENTITY> findAll();

}