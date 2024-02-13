package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IObraRepository extends ElasticsearchRepository<Obra, Long> {
}
