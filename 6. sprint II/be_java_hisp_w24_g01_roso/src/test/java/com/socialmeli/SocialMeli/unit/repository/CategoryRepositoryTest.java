package com.socialmeli.SocialMeli.unit.repository;

import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Category;
import com.socialmeli.SocialMeli.repository.implementations.CategoryRepository;
import com.socialmeli.SocialMeli.repository.interfaces.ICategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CategoryRepositoryTest {
    ICategoryRepository categoryRepository = new CategoryRepository();

    public CategoryRepositoryTest() throws IOException {
    }

    @Test
    @DisplayName("Test that validates if the category is created")
    public void findByIdOrCreateTest(){

        //arrange
        CategoryPostRequestDTO category = new CategoryPostRequestDTO(11, "Art");
        Category expected = new Category(11, "Art");

        //act
        Category result = categoryRepository.findByIdOrCreate(category);

        //assert
        Assertions.assertEquals(expected, result, "The category is not created");
    }
}
