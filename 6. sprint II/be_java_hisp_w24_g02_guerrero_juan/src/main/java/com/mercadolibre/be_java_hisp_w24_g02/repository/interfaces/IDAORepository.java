package com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface IDAORepository <ENTITY> {
    public ENTITY save(ENTITY entity);
    public List<ENTITY> findAll();
    public Optional<ENTITY> findById(Integer id);
    public ENTITY update(ENTITY entity);
    public void delete(Integer id);
}
