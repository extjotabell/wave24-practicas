package com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.repository;

import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {

    //esto es opcional dado que se uda JPA


    List<Personaje> findByName(String name);
}
