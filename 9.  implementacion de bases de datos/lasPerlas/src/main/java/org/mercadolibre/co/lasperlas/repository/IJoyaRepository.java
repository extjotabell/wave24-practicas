package org.mercadolibre.co.lasperlas.repository;

import org.mercadolibre.co.lasperlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

}
