package com.mercadolibre.be_java_hisp_w24_g02.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CreateProductDTO(
        @NotNull(message = "El  id no puede estar vacío")
        @Min(value = 0, message = "El id debe ser mayor a cero")
        @JsonProperty("product_id")
        Integer productId,
        @NotNull(message = "El campo no puede estar vacío")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(min = 1, max = 40, message = "La longitud no puede superar los 40 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
        @JsonProperty("product_name")
        String productName,
        @NotNull(message = "El campo no puede estar vacío")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(min = 1, max = 15, message = "La longitud no puede superar los 15 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
        String type,
        @NotNull(message = "El campo no puede estar vacío")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(min = 1, max = 25, message = "La longitud no puede superar los 25 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
        String brand,
        @NotNull(message = "El campo no puede estar vacío")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(min = 1, max = 15, message = "La longitud no puede superar los 15 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9&\\s]*$", message = "El campo no puede poseer caracteres especiales")
        String color,
        @Size(min = 1, max = 80, message = "La longitud no puede superar los 80 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
        String notes
) {}
