package org.example.starwars.repository;

import org.example.starwars.entity.Personaje;

import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {

    ArrayList<Personaje> findByName(String name);
}

