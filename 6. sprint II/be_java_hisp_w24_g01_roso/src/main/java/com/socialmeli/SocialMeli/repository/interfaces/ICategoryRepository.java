package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Category;

import java.util.Optional;

public interface ICategoryRepository{
    Category findByIdOrCreate(CategoryPostRequestDTO product);
    Optional<Category> findById(Integer id);
}
