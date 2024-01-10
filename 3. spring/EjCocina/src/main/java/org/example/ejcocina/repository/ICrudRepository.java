package org.example.ejcocina.repository;

import java.util.List;

public interface ICrudRepository<ENTITY> {
    ENTITY save();
    ENTITY update();
    Boolean delete();
    List<ENTITY> findAll();
    ENTITY findById();
}
