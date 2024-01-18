package org.be_java_hisp_w24_g05.dto;


import com.fasterxml.jackson.annotation.JsonProperty;


public record PromoPostDto(
        @JsonProperty("user_id") Integer userId,
        String date,
        ProductDto product,
        Integer category,
        Double price,
        @JsonProperty("has_promo")Boolean hasPromo,
        Double discount

) {
}
