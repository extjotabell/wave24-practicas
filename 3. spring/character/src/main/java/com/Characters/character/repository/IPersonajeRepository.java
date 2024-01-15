package com.Characters.character.repository;

import com.Characters.character.entity.Personaje;

import java.util.ArrayList;


public interface IPersonajeRepository extends ICrudRepository<Personaje> {

    Boolean deleteById(Integer id);

    ArrayList<Personaje> findByName(String name);

}
