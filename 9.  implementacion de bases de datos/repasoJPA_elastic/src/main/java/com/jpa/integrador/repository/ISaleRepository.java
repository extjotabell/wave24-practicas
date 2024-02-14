package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
    List<Sale> findByDate(LocalDate date);
}
