package com.socialmeli.SocialMeli.repository.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Product;
import com.socialmeli.SocialMeli.repository.interfaces.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {


    private List<Product> listProducts = new ArrayList<>();

    public ProductRepository() throws IOException {
        loadDataBase();

    }
    @Override
    public Product create(Product product) {
        this.listProducts.add(product);
        return product;
    }

    @Override
    public Boolean remove(Product product) {
        return null;
    }

    @Override
    public Optional<Product> update(Product product) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return listProducts.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products;
        file= ResourceUtils.getFile("classpath:json/products.json");
        products= objectMapper.readValue(file,new TypeReference<List<Product>>(){});
        listProducts= products;
    }

    @Override
    public Product findByIdOrCreate(ProductPostRequestDTO productDTO) {
        return this.findById(productDTO.product_id()).orElseGet(() -> this.create(
                new Product(
                        productDTO.product_id(),
                        productDTO.product_name(),
                        productDTO.type(),
                        productDTO.brand(),
                        productDTO.color(),
                        productDTO.notes()
                )
        ));
    }

}
