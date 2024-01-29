package com.socialmeli.SocialMeli.dto;

public record PostResponseDTO(
        Integer id,
        Integer user_id,
        String date,
        Integer product_id,
        String product_name,
        Integer category_id,
        String category_name,
        Double price
) {
}
