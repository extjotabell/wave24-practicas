package com.socialmeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PostPromoRequestDTO(
        Integer user_id,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date,
        ProductPostRequestDTO product,
        CategoryPostRequestDTO category,
        Double price,
        Boolean has_promo,
        Double discount
) {
}
