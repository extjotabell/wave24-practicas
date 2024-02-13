package com.example.configurandojpa.repository;

import com.example.configurandojpa.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
