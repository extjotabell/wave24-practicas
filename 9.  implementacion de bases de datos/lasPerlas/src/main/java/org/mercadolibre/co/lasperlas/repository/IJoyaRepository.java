package org.mercadolibre.co.lasperlas.repository;

import org.mercadolibre.co.lasperlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

    List<Joya> findByEliminadoFalse();

}
