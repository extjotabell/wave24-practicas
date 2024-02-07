package org.jewerly.lasperlas.repository;

import org.jewerly.lasperlas.entity.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
    List<Jewerly> findByIsOnSaleTrue();
}
