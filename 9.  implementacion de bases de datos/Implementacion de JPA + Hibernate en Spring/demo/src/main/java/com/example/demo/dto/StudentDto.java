package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentDto(
        Long id,
        String dni,
        String name,
        @JsonProperty("last_name")
        String lastName
) {
}
