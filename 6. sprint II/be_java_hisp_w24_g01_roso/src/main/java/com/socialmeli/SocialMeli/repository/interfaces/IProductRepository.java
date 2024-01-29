package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Product;

import java.util.Optional;

public interface IProductRepository{
    Product findByIdOrCreate(ProductPostRequestDTO product);
    Product create(Product product);
    Optional<Product> findById(Integer id);
}
