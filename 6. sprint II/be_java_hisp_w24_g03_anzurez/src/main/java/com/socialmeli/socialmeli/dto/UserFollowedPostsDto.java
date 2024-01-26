package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserFollowedPostsDto(
        @JsonProperty("user_id")
        Integer userId,
        List<PostDto> posts) {
}
