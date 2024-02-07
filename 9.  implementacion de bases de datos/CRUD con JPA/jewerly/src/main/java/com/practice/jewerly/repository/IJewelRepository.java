package com.practice.jewerly.repository;

import com.practice.jewerly.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IJewelRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findByVentaONoIsTrue();
}
