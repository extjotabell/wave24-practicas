package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
}
