package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.dto.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Product;

public interface IProductRepository extends ICrudRepository<Product>{
    Product findByIdOrCreate(ProductPostRequestDTO product);
}
