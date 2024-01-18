package com.socialmeli.socialmeli.dto;

import java.util.List;

public record UserFollowedPostsDto(Integer user_id, List<PostDto> posts) {
}
