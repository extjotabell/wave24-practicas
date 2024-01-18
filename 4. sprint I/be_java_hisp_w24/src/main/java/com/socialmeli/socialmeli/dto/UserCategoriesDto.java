package com.socialmeli.socialmeli.dto;

import com.socialmeli.socialmeli.entities.Product;

import java.util.List;
import java.util.Map;

public record UserCategoriesDto(
        Integer user_id,
        String user_name,
        Map<Integer, List<ProductDto>> categories
) {
}
