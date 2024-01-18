package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.dto.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Category;

public interface ICategoryRepository extends ICrudRepository<Category>{
    Category findByIdOrCreate(CategoryPostRequestDTO product);
    boolean categoryExists(int category_id);
    public Category findByIdNoDTO(Integer categoryDTO);
}
