package com.practica.calculadora.repository;

import com.practica.calculadora.entity.Plate;

import java.util.Optional;

public interface IPlateRepository extends ICrudRepository<Plate> {
    Optional<Plate> findPlateByName(String name);
}
