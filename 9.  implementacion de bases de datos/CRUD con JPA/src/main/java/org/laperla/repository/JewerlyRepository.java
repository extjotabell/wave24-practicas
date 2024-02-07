package org.laperla.repository;

import org.laperla.entity.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewerly, Long> {
}

