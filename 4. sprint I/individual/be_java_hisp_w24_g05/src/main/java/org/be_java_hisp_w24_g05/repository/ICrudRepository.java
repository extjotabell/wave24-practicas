package org.be_java_hisp_w24_g05.repository;

import java.util.ArrayList;
import java.util.Optional;

public interface ICrudRepository <ENTITY>{

    ENTITY save(ENTITY entity);

    ENTITY update(ENTITY entity);

    Boolean deleteById(Integer id);

    Optional<ENTITY> findById(Integer id);

    ArrayList<ENTITY> findAll();

}
