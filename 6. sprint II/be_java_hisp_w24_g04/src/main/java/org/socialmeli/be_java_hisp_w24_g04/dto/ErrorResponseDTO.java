package org.socialmeli.be_java_hisp_w24_g04.dto;

import jakarta.validation.constraints.NotNull;

public record ErrorResponseDTO(
        Integer status,
        @NotNull(message = "Error message can't be null or empty.") String error
) {
}
