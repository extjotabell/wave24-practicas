package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserBasicInfoDTO(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName
) {

}
