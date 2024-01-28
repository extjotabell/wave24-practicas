package com.socialmeli.SocialMeli.dto.requestDTO;

import jakarta.validation.constraints.*;

public record ProductPostRequestDTO(
        @Min(value = 1, message = "The product id must be greater than zero")
        @NotNull(message = "The id cannot be empty.")
        Integer product_id,
        @NotEmpty(message = "The product name field cannot be empty")
        @Size(max = 40, message = "The product name length cannot exceed 40 characters.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The product name field cannot contain special characters.")
        String product_name,
        @NotEmpty(message = "The type field cannot be empty")
        @Size(max = 15, message = "The type length cannot exceed 15 characters.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The field cannot contain special characters.")
        String type,
        @NotEmpty(message = "The field brand cannot be empty")
        @Size(max = 25, message = "The brand length cannot exceed 25 characters.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The brand field cannot contain special characters.")
        String brand,
        @NotEmpty(message = "The color field cannot be empty")
        @Size(max = 15, message = "The color length cannot exceed 15 characters.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The color field cannot contain special characters.")
        String color,
        @Size(max = 80, message = "The notes length cannot exceed 80 characters.")
        String notes
) {

}
