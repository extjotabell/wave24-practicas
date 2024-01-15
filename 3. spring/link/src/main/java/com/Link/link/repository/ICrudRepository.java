package com.Link.link.repository;

import com.Link.link.entity.Link;

import java.util.ArrayList;
import java.util.Optional;

public interface ICrudRepository <ENTITY>{
    ENTITY save(ENTITY entity);
    ENTITY update(ENTITY entity);
    Boolean deleteByid(Integer id);
    Optional<ENTITY> findById(Link id);
    ArrayList<ENTITY> findAll();
}
