package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PromoPostCountDto(Integer user_id, String user_name, Integer promo_products_count) {
}
