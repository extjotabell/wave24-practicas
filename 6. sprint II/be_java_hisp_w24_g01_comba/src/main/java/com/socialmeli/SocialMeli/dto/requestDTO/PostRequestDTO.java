package com.socialmeli.SocialMeli.dto.requestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostRequestDTO(
        @NotNull(message = "User id must not be empty")
        @Min(value = 1, message = "User id must be greater than 0")
        Integer user_id,

        @NotNull(message = "Date must not be empty")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date,
        @Valid
        ProductPostRequestDTO product,

        @Valid
        CategoryPostRequestDTO category,

        @NotNull(message = "The price field cannot be empty")
        @Max(value = 10000000, message = "The maximum price per product is 10,000,000")
        Double price
) {
}
