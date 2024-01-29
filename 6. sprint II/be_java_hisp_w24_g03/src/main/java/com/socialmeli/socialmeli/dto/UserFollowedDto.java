package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserFollowedDto(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName,
        List<UserDto> followed) {
}
