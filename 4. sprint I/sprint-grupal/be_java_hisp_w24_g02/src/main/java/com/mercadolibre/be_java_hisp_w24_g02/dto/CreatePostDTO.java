package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CreatePostDTO(
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
        Double price
) {}
