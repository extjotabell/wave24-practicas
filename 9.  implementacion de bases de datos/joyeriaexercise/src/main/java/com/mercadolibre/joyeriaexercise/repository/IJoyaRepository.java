package com.mercadolibre.joyeriaexercise.repository;

import com.mercadolibre.joyeriaexercise.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJoyaRepository extends JpaRepository<Joya, Integer> {
    List<Joya> findByVentaONoIsTrue();
}

