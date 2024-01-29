package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostDto(
        @JsonProperty("user_id")
        @NotNull(message="El id del usuario es obligatorio")
        @Min(value = 1, message = "El id del usuario debe ser mayor a 0")
        Integer userId,
        @NotNull(message="La fecha es obligatorio")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateSerializer.class)
        @JsonFormat(pattern ="dd-MM-yyyy")
        LocalDate date,
        @Valid
        ProductDto product,
        @NotNull(message="La categoria es obligatorio")
        Integer category,
        @NotNull(message="El precio es obligatorio")
        @Max(value = 10000000, message = "El precio maximo debe ser de 10000000")
        Double price) {
}
