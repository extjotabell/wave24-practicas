package org.joyeria.joyeria.dto.Response;

import org.springframework.http.HttpStatus;

public record ErrorResponseDTO(Short code, String message) {
    public static ErrorResponseDTO buildErrorResponse(HttpStatus status, String message) {
        return new ErrorResponseDTO((short) status.value(), message);
    }
}
