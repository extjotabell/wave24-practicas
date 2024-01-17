package com.socialmeli.SocialMeli.dto;

public record PostPromoCountResponseDTO(
        Integer user_id,
        String user_name,
        Integer promo_products_count
) {
}
