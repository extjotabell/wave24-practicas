package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public record PromoPostDto(Integer user_id,
                           @JsonFormat(pattern = "dd-MM-yyyy") LocalDate date,
                           ProductDto product,
                           Integer category,
                           Double price,
                           Boolean has_promo,
                           Double discount) {
}
