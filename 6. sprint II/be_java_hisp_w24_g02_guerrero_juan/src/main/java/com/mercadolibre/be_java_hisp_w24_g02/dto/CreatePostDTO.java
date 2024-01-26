package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreatePostDTO(
        @NotNull(message = "El  id no puede estar vacío")
        @Min(value = 0, message = "El id debe ser mayor a cero")
        @JsonProperty("user_id")
        Integer userId,
        @NotNull(message = "La fecha no puede estar vacía")
        String date,
        @NotNull
        @Valid CreateProductDTO product,
        @NotNull
        Integer category,
        @NotNull
        @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
        Double price
) {}
