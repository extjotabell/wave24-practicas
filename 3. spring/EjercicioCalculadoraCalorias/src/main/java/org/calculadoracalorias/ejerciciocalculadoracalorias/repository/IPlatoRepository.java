package org.calculadoracalorias.ejerciciocalculadoracalorias.repository;

import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Plato;

public interface IPlatoRepository {
    Plato findByName(String name);

}
