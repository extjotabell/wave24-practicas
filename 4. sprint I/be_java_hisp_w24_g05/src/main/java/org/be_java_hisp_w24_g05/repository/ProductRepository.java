package org.be_java_hisp_w24_g05.repository;

import org.be_java_hisp_w24_g05.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    private ArrayList<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }
    @Override
    public Product save(Product product) {
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
        return Optional.empty();
    }

    @Override
    public ArrayList<Product> findAll() {
        return null;
    }

    // Recent posts of followed users
}
