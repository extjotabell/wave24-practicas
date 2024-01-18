package com.socialmeli.socialmeli.dto;

public record UserProductsDto(
        Integer user_id,
        String user_name,
        Integer promo_products_count
) {
}
