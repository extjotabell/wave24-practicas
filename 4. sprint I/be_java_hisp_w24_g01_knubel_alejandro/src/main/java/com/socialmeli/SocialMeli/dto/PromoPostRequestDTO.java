package com.socialmeli.SocialMeli.dto;

import jakarta.validation.constraints.NotNull;

public record PromoPostRequestDTO(
        //Validate each field with @notnull annotation and a message for the user

        @NotNull(message = "User ID can not be null")
        Integer user_id,
        @NotNull(message = "Date can not be null")
        String date,

        ProductPostRequestDTO product,
        @NotNull(message = "Category can not be null")
        Integer category,
        @NotNull(message = "Price can not be null")
        Double price,
        @NotNull(message = "Has promo can not be null")
        Boolean has_promo,
        @NotNull(message = "Discount can not be null")
        Double discount) {
}
