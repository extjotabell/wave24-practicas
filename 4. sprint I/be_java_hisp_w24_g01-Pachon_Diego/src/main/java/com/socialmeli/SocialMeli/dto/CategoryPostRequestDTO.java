package com.socialmeli.SocialMeli.dto;

public record CategoryPostRequestDTO(
        Integer category_id,
        String category_name
) {
    public Integer category_id(){
        if (category_id != null) {
            return category_id;
        } else {
            throw new IllegalArgumentException("Category id cannot be null");
        }
    }
}
