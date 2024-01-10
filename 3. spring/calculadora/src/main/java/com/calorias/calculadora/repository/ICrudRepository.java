package com.calorias.calculadora.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository <Entity>{
    List<Entity> findAll();
    Optional<Entity> findByName(String name);
}
