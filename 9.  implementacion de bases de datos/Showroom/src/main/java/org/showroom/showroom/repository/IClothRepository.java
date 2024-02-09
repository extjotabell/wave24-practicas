package org.showroom.showroom.repository;

import org.showroom.showroom.domain.Cloth;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IClothRepository extends ElasticsearchRepository<Cloth, String> {
    List<Cloth> findBySizeEquals(String size);
    List<Cloth> findByNameContaining(String name);
}
