package com.practice.testers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.List;

public record MessageDTO(
        @JsonProperty("status_code")
        HttpStatus statusCode,
        String message,
        List<TestCaseDTO> body
) {
}
