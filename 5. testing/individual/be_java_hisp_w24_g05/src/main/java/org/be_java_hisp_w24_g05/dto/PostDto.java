package org.be_java_hisp_w24_g05.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record PostDto(
        @JsonProperty("user_id")
        @Min(value = 1000, message = "El id del usuario debe ser mayor a 1000")
        @NotNull(message = "El id del usuario no puede ser nulo")
        Integer userId,
        @NotEmpty(message = "La fecha no puede ser vacía")
        @Size(min = 10, max = 10, message = "La fecha debe tener el formato yyyy-MM-dd")
        String date,
        ProductDto product,

        Integer category,
        Double price
){}
