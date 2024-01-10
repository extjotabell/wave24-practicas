package org.calculadoracalorias.ejerciciocalculadoracalorias.repository;

import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Comida;

public interface IComidaRepository {
    Comida findByName(String name);
}
