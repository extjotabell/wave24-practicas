package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PromoPostAndUserInfoDTO(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName,
        List<PromoProductPostDTO> posts

) {
}
