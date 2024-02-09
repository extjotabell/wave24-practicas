package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepo extends JpaRepository<Sale, Integer> {
        List<Sale> findByDateEquals(LocalDate date);
        @Query( "SELECT s.clothList FROM Sale s WHERE s.id = :id")
        List<Cloth> searchListClothes(Integer id);
}
