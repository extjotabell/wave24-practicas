package com.socialmeli.SocialMeli.dto.responseDTO;

import java.util.List;


public record LastestPostDTO(
        Integer user_id,
        List<PostWithIdDTO> posts
) {
}
