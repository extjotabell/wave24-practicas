package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserFollowersDto(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName, Integer followers_count) {
}