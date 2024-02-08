package com.bootcamp.Joyas.repository;

import com.bootcamp.Joyas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJoyaRepository extends JpaRepository<Joya, Long> {
    List<Joya> findAllByVentaONo(Boolean ventaONo);
}
