package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ProductDto(
        @JsonProperty("product_id")
        @NotNull(message="El id del producto es obligatorio")
        Integer productId,
        @Size(max = 40, message = "El nombre del producto no puede tener una longitud mas de 40")
        @NotNull(message="El nombre es obligatorio")
        @Pattern(regexp = "[a-zA-Z0-9\\s]+", message="El nombre producto solo puede contener letras o números")
        @JsonProperty("product_name")
        String productName,
        @Size(max = 15, message = "La marca no puede tener una longitud mas de 15")
        @Pattern(regexp = "[a-zA-Z0-9\\s]+", message="El tipo del producto solo puede contener letras o números")
        @NotNull(message="El tipo de producto es obligatorio")
        String type,
        @Size(max = 25, message = "La marca no puede tener una longitud mas de 25")
        @Pattern(regexp = "[a-zA-Z0-9\\s]+", message="La marca del producto solo puede contener letras o números")
        @NotNull(message="La marca es obligatorio")
        String  brand,
        @Size(max = 15, message = "El color no puede tener una longitud mas de 15")
        @Pattern(regexp = "[a-zA-Z0-9\\s]+", message="El color del producto solo puede contener letras o números")
        @NotNull(message="El color es obligatorio")
        String color,
        @Pattern(regexp = "[a-zA-Z0-9\\s]+", message="Las notas del producto solo puede contener letras o números")
        @Size(max = 80, message = "Las notas no puede tener una longitud mas de 80")
        String notes) {
}
