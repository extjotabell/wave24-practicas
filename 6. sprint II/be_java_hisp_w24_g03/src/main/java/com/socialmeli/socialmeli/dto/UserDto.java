package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;

public record UserDto(
        @JsonProperty("user_id")
        Integer userId,
        @Size(max = 15, message = "El nombre no puede tener una longitud mas de 15")
        @JsonProperty("user_name")
        String userName) {
}
