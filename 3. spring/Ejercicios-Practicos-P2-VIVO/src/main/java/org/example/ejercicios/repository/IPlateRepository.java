package org.example.ejercicios.repository;

import org.example.ejercicios.entity.Plate;

import java.util.Optional;

public interface IPlateRepository extends ICrudRepository<Plate> {


    public Plate findByName(String name);
}
