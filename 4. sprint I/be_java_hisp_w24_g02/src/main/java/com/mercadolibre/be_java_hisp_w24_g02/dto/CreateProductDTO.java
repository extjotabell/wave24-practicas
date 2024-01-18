package com.mercadolibre.be_java_hisp_w24_g02.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductDTO(
        @NotNull
        @JsonProperty("product_id")
        Integer productId,
        @NotNull
        @NotBlank
        @JsonProperty("product_name")
        String productName,
        @NotNull
        @NotBlank
        String type,
        @NotNull
        @NotBlank
        String brand,
        @NotNull
        @NotBlank
        String color,
        @NotNull
        @NotBlank
        String notes
) {}
