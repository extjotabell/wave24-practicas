package org.mercadolibre.co.calorias.repository;

import org.mercadolibre.co.calorias.entity.Ingrendiente;

public interface IIngredienteRespository extends ICrudRepository<Ingrendiente, Integer>{

    Ingrendiente findByName(String name);

}
