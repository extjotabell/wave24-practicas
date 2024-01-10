package org.example.ejarqmulticapa.starwars.personaje.repository;

import java.util.List;

public interface Repository<T> {

    List<T> findByName(String name);

}
