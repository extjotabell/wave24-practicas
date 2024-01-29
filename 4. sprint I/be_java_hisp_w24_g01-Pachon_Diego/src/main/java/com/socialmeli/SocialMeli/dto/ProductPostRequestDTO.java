package com.socialmeli.SocialMeli.dto;

public record ProductPostRequestDTO(
        Integer product_id,
        String product_name,
        String type,
        String brand,
        String color,
        String notes
) {
    public Integer product_id(){
        if (product_id != null) {
            return product_id;
        } else {
            throw new IllegalArgumentException("Product id cannot be null");
        }
    }
}
