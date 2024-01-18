package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDto(
        @JsonProperty("product_id") Integer productId,
        @JsonProperty("product_name") String productName,
        String type,
        String brand,
        String color,
        String note
) {
}
