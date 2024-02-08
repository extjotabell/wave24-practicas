package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRespository extends JpaRepository<Sale, Integer> {
    List<Sale> findByDate(LocalDate date);
}
