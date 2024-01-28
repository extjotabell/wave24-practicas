package com.socialmeli.SocialMeli.dto;

import jakarta.validation.constraints.Pattern;

public record ProductResponseDTO(

        @Pattern(regexp = "^[0-9]+$", message = "ID must be Integer")
        Integer user_id,
        String user_name,

        Integer promo_products_count
) {
}
