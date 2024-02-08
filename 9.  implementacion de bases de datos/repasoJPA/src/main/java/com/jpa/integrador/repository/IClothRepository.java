package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClothRepository extends JpaRepository <Cloth, Integer> {

    List<Cloth> findClothBySize(String size);

    List<Cloth> findByNameContains(String name);


}
