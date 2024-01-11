package org.mercadolibre.co.calorias.repository;

import org.mercadolibre.co.calorias.entity.Plato;

import java.util.Optional;

public interface IPlatoRepository extends ICrudRepository<Plato, Integer>{

    Plato findByName(String name);

}
