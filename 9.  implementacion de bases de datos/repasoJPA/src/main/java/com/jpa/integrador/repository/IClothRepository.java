package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothRepository extends JpaRepository<Cloth, Integer>{

    List<Cloth> findClothsByNameLike(String name);
    List<Cloth> findClothsBySizeEquals(String size);
}
