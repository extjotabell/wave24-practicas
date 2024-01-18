package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.entities.Product;

import java.util.ArrayList;

public interface IProductRepository extends ICrudRepository<Product> {
    ArrayList<Product> loadProductJson();
}
