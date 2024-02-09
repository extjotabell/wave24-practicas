package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClothRepo extends JpaRepository<Cloth, Integer> {
    List<Cloth> findByNameLike(String name);

    List<Cloth> findBySize(String size);
}
