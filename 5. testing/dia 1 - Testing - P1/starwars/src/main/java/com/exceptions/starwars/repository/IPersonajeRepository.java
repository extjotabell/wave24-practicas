package com.exceptions.starwars.repository;

import com.exceptions.starwars.entity.Personaje;

import javax.tools.JavaCompiler;
import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {

    ArrayList<Personaje> findByName(String name);

}
