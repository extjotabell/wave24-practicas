package com.bootcamp.calories.repository;

import com.bootcamp.calories.entity.Plate;


public interface IPlateRepository extends ICrudRepository<Plate> {

    Plate findByName(String name);
}