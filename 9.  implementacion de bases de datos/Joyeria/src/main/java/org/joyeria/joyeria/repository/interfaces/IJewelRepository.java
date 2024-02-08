package org.joyeria.joyeria.repository.interfaces;

import org.joyeria.joyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IJewelRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findByIsForSaleIsTrue(Pageable pageable);
}
