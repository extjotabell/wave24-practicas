package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CountPromoPostDto(
        @JsonProperty("user_id")
        int userId,
    @JsonProperty("user_name")
    String userName,
    @JsonProperty("promo_products_count")
    int promoProductCount
) {
}
