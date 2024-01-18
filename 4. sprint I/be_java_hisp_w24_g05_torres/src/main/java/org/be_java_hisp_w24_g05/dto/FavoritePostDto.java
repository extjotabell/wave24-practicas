package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FavoritePostDto(
        @JsonProperty("user_id")
    Integer userId,
        @JsonProperty("post_id")
    Integer postId
) {
}
