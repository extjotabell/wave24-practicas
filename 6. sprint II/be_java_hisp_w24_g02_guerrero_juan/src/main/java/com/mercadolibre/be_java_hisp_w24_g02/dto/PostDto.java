package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;

import java.time.LocalDate;

public record PostDto(
        @JsonProperty("post_id")
        Integer postId,
        @JsonProperty("user_id")
        Integer userId,
        LocalDate date,
        Product product,
        Integer category,
        Double price
) {
}
