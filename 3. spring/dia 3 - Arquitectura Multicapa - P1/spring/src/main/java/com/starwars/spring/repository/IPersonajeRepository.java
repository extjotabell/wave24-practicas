package com.starwars.spring.repository;

import com.starwars.spring.entity.Personaje;

import javax.tools.JavaCompiler;
import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {

    ArrayList<Personaje> findByName(String name);

}
