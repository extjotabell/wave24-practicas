package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.dto.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.ProductResponseDTO;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.Product;

import java.util.List;

public interface IPostRepository extends ICrudRepository<Post>{

    int findLastId();

    List<Post> getAllPostsById(Integer userId);

    Integer productsPromo (Integer userId);

    List<Post> searchPostBycategory(String category, Double price);
}
