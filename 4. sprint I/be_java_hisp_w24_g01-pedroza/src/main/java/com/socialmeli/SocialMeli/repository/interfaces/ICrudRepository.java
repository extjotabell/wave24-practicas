package com.socialmeli.SocialMeli.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository <ENTITY>{

    ENTITY create (ENTITY entity);
    Boolean remove (ENTITY entity);
    Optional<ENTITY> update(ENTITY entity);
    Optional<ENTITY> findById(Integer id);
    List<ENTITY> getAll();

}
