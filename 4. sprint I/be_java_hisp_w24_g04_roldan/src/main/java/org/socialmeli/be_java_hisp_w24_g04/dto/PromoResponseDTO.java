package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Product;

public record PromoResponseDTO(
        Integer user_id,
        String date,
        Product product,
        Integer category,
        Double price,
        Boolean has_promo,
        Double discount
) {
}
