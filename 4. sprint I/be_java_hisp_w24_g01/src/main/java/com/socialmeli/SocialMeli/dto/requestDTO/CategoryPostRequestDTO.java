package com.socialmeli.SocialMeli.dto.requestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryPostRequestDTO(
        @NotNull(message = "Category id must not be empty")
        @Min(value = 1, message = "Category id must be greater than 0")
        Integer category_id,
        @NotEmpty(message = "Category name must not be empty")
        @Size(max = 15, message = "Category name must be less than 15 characters")
        String category_name
) {

}
