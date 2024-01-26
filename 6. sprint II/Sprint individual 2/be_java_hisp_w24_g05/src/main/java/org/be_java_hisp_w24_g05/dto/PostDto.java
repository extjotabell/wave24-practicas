package org.be_java_hisp_w24_g05.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;




public record PostDto(
        @NotNull(message = "userId no puede estar vacio")
        @Min(value=1, message = "userId tiene que ser mayor a 0")
        @JsonProperty("user_id") Integer userId,
        @NotBlank(message = "La fecha no debe estar vacía")
        String date,
        @Valid ProductDto product,
        @NotNull(message = "El campo category no puede estar vacío.")
        Integer category,
        @NotNull(message = "El campo price no puede estar vacío.")
        @DecimalMax(value = "10000000.0", message = "El precio máximo por producto es de 10.000.000")
        Double price
) {
}
