package com.socialmeli.SocialMeli.dto;

public record ProductPostRequestDTO(
        Integer product_id,
        String product_name,
        String type,
        String brand,
        String color,
        String notes
) {
}
