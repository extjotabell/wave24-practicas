package org.socialmeli.be_java_hisp_w24_g04.dto;

import jakarta.validation.constraints.*;
import org.socialmeli.be_java_hisp_w24_g04.model.User;

public record UserDTO(
        @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
        @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
        Integer user_id,

        @NotNull(message = "El campo product_name no puede estar vacío.")
        @Max(value = 60, message = "La longitud no puede superar los 60 caracteres.")
        @Min(value = 3, message = "La longitud no puede ser menor a 3 caracteres.")
        @NotBlank(message = "El campo product_name no puede estar vacío.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo user_name no puede poseer caracteres especiales.")
        String user_name
) {
    public UserDTO(User user) {
        this(user.getUserId(), user.getUsername());
    }
}
