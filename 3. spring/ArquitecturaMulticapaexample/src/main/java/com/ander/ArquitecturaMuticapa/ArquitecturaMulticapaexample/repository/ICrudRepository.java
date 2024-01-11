package com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository <ENTITY>{

    ENTITY save(ENTITY entity);
    ENTITY update(ENTITY entity);
    Boolean deleteById(Integer id);
    Optional<ENTITY> findById(Integer id);
    List<ENTITY> findAll();
}
