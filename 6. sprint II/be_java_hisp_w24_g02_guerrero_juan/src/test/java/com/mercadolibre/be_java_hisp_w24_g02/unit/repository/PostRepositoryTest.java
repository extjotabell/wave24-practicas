package com.mercadolibre.be_java_hisp_w24_g02.unit.repository;

import com.mercadolibre.be_java_hisp_w24_g02.repository.implementations.PostRepositoryImpl;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IPostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostRepositoryTest {
    IPostRepository postRepository = new PostRepositoryImpl();

    @Test
    public void shouldFindAllSizeList() {
        // Arrange
        Integer sizeExpected = 12;
        // Act
        Integer sizeResult = postRepository.findAll().size();
        // Assert
        Assertions.assertEquals(sizeExpected, sizeResult);
    }
}
