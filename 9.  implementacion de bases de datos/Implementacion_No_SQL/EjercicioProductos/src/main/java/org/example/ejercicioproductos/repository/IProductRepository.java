package org.example.ejercicioproductos.repository;

import org.example.ejercicioproductos.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductRepository extends ElasticsearchRepository<Product, Long> {
}
