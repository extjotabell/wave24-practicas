package org.mercadolibre.co.starwars.repository;

import org.mercadolibre.co.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository extends ICrudRepository<Personaje, String>{

    List<Personaje> findByName(String name);

}
