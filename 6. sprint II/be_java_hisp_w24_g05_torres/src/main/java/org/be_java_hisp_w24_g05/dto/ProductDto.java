package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.*;


public record ProductDto(
        @NotNull(message = "El product_id no debe estar vacío")
        @Min(value=1, message = "El product_id debe ser mayor que 0")
        @JsonProperty("product_id") Integer productId,
        @NotBlank(message = "El product_name no debe estar vacío")
        @Size(max = 40, message = "La longitud máxima del product_name es 40 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El product_name no debe contener caracteres especiales")
        @JsonProperty("product_name") String productName,
        @NotBlank(message = "El type no debe estar vacío")
        @Size(max = 15, message = "La longitud máxima del type es 15 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El type no debe contener caracteres especiales")
        String type,
        @Size(max = 25,message = "La longitud de brand no puede superar los 25 caracteres.")
        @NotBlank(message = "El campo brand no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo brand no puede poseer caracteres especiales.")
        String brand,
        @Size(max = 15,message = "La longitud de color no puede superar los 15 caracteres.")
        @NotBlank(message = "El campo color no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo color no puede poseer caracteres especiales.")
        String color,
        @Size(max = 80,message = "La longitud no puede superar los 80 caracteres.")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo notes no puede poseer caracteres especiales.")
        String notes
) {
}
