package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IClothRepository extends ElasticsearchRepository<Cloth, String> {
    List<Cloth> findBySize(String size);
    List<Cloth> findByNameContaining(String name);
}
