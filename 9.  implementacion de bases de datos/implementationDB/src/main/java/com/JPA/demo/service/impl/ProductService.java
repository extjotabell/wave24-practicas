package com.JPA.demo.service.impl;

import com.JPA.demo.dto.ProductDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.entity.Product;
import com.JPA.demo.repository.interfaces.IProductRepository;
import com.JPA.demo.service.interfaces.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public ProductDTO saveEntity(ProductDTO productDTO) {
        Product productEntity = mapToEntity(productDTO);
        productEntity = productRepository.save(productEntity);
        return mapToDTO(productEntity);
    }

    @Override
    public ProductDTO getEntityById(Integer id) {
        Product productEntity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return mapToDTO(productEntity);
    }

    @Override
    public List<ProductDTO> getAllEntities() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new MessageDTO("The product with id was removed: " + id, "Delete");
        } else {
            return new MessageDTO("The product with id does not exist or could not be deleted: " + id, "Delete");
        }
    }

    private Product mapToEntity(ProductDTO productDTO) {
        return new Product(
                productDTO.id(),
                productDTO.name(),
                productDTO.description()
        );
    }

    private ProductDTO mapToDTO(Product productEntity) {
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription()
        );
    }

}