package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothRespository extends JpaRepository<Cloth, Integer> {
    List<Cloth> findClothBySize(String size);
    List<Cloth> findByNameContains(String name);


}
