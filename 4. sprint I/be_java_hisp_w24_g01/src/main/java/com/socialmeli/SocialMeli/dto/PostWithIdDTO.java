package com.socialmeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PostWithIdDTO(
        Integer user_id,
        Integer post_id,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate date,
        ProductPostRequestDTO product,
        CategoryPostRequestDTO category,
        Double price
) {
}
