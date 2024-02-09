package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Integer>{
    List<Sale> findSaleByDate(LocalDate date);
}
