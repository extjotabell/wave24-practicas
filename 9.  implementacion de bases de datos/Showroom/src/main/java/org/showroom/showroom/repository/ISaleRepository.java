package org.showroom.showroom.repository;

import org.showroom.showroom.domain.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
    List<Sale> findByDateEquals(LocalDate date);
}
