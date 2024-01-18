package com.socialmeli.SocialMeli.dto;

import java.util.List;


public record LastestPostDTO(
        Integer user_id,
        List<PostWithIdDTO> posts
) {
}
