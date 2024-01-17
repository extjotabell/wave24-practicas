package org.example.ejercicio.repository;

import org.example.ejercicio.entity.EntradaBlog;

public interface IEntradaBlogRepository extends ICrudRepository<EntradaBlog> {

    public EntradaBlog findById(Long id);
}
