package org.example.joyeria.repository;

import org.example.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyeriaRepository extends JpaRepository<Joya, Long> {
}
