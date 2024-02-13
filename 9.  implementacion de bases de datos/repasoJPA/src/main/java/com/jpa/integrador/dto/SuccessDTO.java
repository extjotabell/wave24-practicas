package com.jpa.integrador.dto;

import org.springframework.http.HttpStatusCode;

public record SuccessDTO(
        String message,
        Integer code) {
}
