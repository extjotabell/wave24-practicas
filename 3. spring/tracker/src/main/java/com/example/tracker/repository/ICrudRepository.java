package com.example.tracker.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository <ENTITY>{

    ENTITY save(String  entity);
    ENTITY update(ENTITY entity);
    Boolean deleteById(Integer id);
    Optional<ENTITY> findById(Integer id);
    List<ENTITY> findAll();
}
