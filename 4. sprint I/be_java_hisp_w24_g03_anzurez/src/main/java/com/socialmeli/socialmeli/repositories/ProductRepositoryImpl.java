package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.socialmeli.socialmeli.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    private final ArrayList<Product> products;

    public ProductRepositoryImpl() {
        this.products = loadProductJson();
    }

    @Override
    public Product save(Product product) {
        if(this.products.add(product)){
            return product;
        }

        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return this.products.stream().filter(
                product -> product.getProductId().equals(id)
        ).findFirst();
    }

    @Override
    public ArrayList<Product> findAll() {
        return this.products;
    }

    @Override
    public ArrayList<Product> loadProductJson() {
        ArrayList<Product> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Product>> typeReference = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/product.json");
            data = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
