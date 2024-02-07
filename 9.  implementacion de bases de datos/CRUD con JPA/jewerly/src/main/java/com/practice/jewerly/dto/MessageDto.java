package com.practice.jewerly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageDto(
        @JsonProperty("status_code")
        Integer statusCode,
        String message
) {
}
