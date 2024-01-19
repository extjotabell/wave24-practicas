package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record PromoPostDTO(
        @NotNull
        @JsonProperty("post_id")
        Integer postId,
        @NotNull
        @JsonProperty("user_id")
        Integer userId,
        @NotNull
        String date,
        @NotNull
        CreateProductDTO product,
        @NotNull
        Integer category,
        @NotNull
        Double price,
        @NotNull
        @JsonProperty("has_promo")
        Boolean hasPromo,
        @NotNull
        Double discount
) {
}
