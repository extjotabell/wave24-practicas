package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra, Long> {

    List<Obra> findByAutor(String autor);
}
