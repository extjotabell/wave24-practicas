package org.starwars.ejerciciostarwars.repository;

import org.starwars.ejerciciostarwars.entity.Personaje;

import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {
    ArrayList<Personaje> findByName(String name);
}
