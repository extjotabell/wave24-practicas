package com.mercadolibre.cardealership.repository;

import java.util.List;
import java.util.Optional;

public interface DAORepository<ENTITY> {
    public ENTITY create(ENTITY entity);
    public Optional<ENTITY> findById(String id);
    public List<ENTITY> findAll();
}
