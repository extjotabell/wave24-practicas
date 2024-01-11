package com.example.calculadoracalorias.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    Optional<T> findByName(String name);

    List<T> findAll();

}
