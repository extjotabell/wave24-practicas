package com.bootcampW22.EjercicioGlobal.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ICrudRepository <ENTITY>{

    ENTITY save(ENTITY entity);
    ENTITY update(ENTITY entity);
    Boolean deleteById(Integer id);
    Optional<ENTITY> findByID(ENTITY entity);
    ArrayList<ENTITY> findAll();


}
