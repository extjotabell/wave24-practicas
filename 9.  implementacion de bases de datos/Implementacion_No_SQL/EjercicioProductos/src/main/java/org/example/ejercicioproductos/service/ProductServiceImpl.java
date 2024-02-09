package org.example.ejercicioproductos.service;

import org.example.ejercicioproductos.dto.ProductDTO;
import org.example.ejercicioproductos.domain.Product;
import org.example.ejercicioproductos.mapper.Mapper;
import org.example.ejercicioproductos.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    private final Mapper mapper;
    private final IProductRepository productRepository;

    public ProductServiceImpl(Mapper mapper, IProductRepository productRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = mapper.convertDtoToEntity(productDTO);
        productRepository.save(product);
        return mapper.convertEntityToDto(product);
    }
}
