package org.example.hqlvehiculosasegurados.repository;

import org.example.hqlvehiculosasegurados.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
