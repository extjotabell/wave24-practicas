package com.joyeria.Joya.repository;

import com.joyeria.Joya.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJewelRepository extends JpaRepository <Jewel, Long> {
    List<Jewel> findByForSaleIsTrueAnd();

}
