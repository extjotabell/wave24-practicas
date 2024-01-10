package org.example.ejcocina.repository;

import org.example.ejcocina.entity.Plate;

import java.util.Optional;

public interface IPlateRepository extends ICrudRepository<Plate> {


    public Plate findByName(String name);
}
