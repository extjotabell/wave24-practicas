package org.socialmeli.be_java_hisp_w24_g04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;

import java.time.LocalDate;

public record PostDTO(
        @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
        @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
        Integer user_id,

        @NotNull(message = "Parámetro post_id faltante (tipo Integer).")
        @PositiveOrZero(message = "El post_id debe ser mayor a cero.")
        Integer post_id,

        @NotNull(message = "Parametro date faltante (tipo Date).")
        @NotBlank(message = "La fecha no puede estar vacía.")
        @JsonFormat(pattern = "dd-MM-yyyy")
        String date,

        @Valid
        ProductDTO product,

        @NotNull(message = "El campo category no puede estar vacío.")
        Integer category,

        @NotNull(message = "El campo price no puede estar vacío.")
        @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
        Double price
) {
}
