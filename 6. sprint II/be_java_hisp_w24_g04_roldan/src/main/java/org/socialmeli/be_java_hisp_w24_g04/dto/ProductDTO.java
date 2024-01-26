package org.socialmeli.be_java_hisp_w24_g04.dto;

import jakarta.validation.constraints.*;

public record ProductDTO(
        @NotNull(message = "Parámetro product_id faltante (tipo Integer).")
        @PositiveOrZero(message = "El product_id debe ser mayor a cero.")
        Integer product_id,

        @NotNull(message = "El campo product_name no puede estar vacío.")
        @Size(
                max = 60,
                min = 3,
                message = "La longitud de product_name no puede superar los 60 caracteres o ser menor de 3 caracteres."
        )
        @NotBlank(message = "El campo product_name no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo product_name no puede poseer caracteres especiales.")
        String product_name,

        @NotNull(message = "El campo type no puede estar vacío.")
        @Size(
                max = 15,
                message = "La longitud de type no puede superar los 15 caracteres."
        )
        @NotBlank(message = "El campo type no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo type no puede poseer caracteres especiales.")
        String type,

        @Size(max = 15, message = "La longitud de notes no puede superar los 15 caracteres.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo brand no puede poseer caracteres especiales.")
        String notes,

        @NotNull(message = "El campo brand no puede estar vacío.")
        @Size(
                max = 25,
                message = "La longitud de brand no puede superar los 25 caracteres."
        )
        @NotBlank(message = "El campo brand no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo brand no puede poseer caracteres especiales.")
        String brand,

        @NotNull(message = "El campo type no puede estar vacío.")
        @Size(
                max = 15,
                message = "La longitud de color no puede superar los 15 caracteres."
        )
        @NotBlank(message = "El campo type no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo color no puede poseer caracteres especiales.")
        String color
) {
}
