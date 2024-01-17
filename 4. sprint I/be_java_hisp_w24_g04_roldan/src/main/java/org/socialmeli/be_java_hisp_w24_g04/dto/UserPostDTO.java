package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Product;

import java.time.LocalDate;

public record UserPostDTO(
        Integer user_id,
        String date,
        Product product,
        Integer category,
        Double price
) {
}
