package com.mercadolibre.be_java_hisp_w24_g02.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public record UserFollowedsPostsDTO(
        @JsonProperty("user_id")
        Integer userId,
        List<PostDto> posts
) {

}
