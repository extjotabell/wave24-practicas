package com.practica.starwars.repository;

import com.practica.starwars.entity.Personaje;

import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {
    ArrayList<Personaje> findByName(String name);
}
