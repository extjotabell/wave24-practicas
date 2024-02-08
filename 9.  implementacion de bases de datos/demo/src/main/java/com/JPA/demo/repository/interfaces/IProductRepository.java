package com.JPA.demo.repository.interfaces;

import com.JPA.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
