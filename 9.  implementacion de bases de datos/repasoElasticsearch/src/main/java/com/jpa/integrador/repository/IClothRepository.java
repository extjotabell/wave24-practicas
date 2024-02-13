package com.jpa.integrador.repository;

import com.jpa.integrador.domain.Cloth;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IClothRepository extends ElasticsearchRepository<Cloth, Integer> {

    List<Cloth> findClothsByNameLike(String name);
    List<Cloth> findClothsBySizeEquals(String size);
}
