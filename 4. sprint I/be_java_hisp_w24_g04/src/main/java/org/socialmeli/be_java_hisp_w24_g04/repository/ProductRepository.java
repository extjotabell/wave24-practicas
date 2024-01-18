package org.socialmeli.be_java_hisp_w24_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    private List<Product> productRepository;
    private String jsonFile = "classpath:data/products.json";

    public ProductRepository() {
        this.productRepository = loadProducts();
    }

    private ArrayList<Product> loadProducts() {
        ArrayList<Product> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Product>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile(this.jsonFile);
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Product save(Product entity) {
        if (entity == null)
            return null;

        productRepository.add(entity);

        return entity;
    }

    @Override
    public Product remove(Integer id) {
        var productToDelete = productRepository
                .stream()
                .filter(product -> product.getProductId().equals(id))
                .findFirst()
                .orElse(null);

        if (productToDelete == null)
            return null;

        productRepository.remove(productToDelete);

        return productToDelete;
    }

    @Override
    public Optional<Product> get(Integer id) {
        return productRepository
                .stream()
                .filter(product -> product.getProductId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return productRepository;
    }

    @Override
    public Product update(Product entity) {
        productRepository = productRepository
                .stream()
                .map(product -> product.getProductId().equals(entity.getProductId()) ? entity : product).toList();

        return entity;
    }
}
