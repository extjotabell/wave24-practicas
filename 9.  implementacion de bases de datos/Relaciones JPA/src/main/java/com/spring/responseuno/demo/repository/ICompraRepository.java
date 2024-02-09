package com.spring.responseuno.demo.repository;

import com.spring.responseuno.demo.model.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ICompraRepository extends JpaRepository<Compra, Long> {
}
