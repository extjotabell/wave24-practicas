package com.socialmeli.SocialMeli.dto.responseDTO;

import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;

import java.util.List;

public record UserFollowerDTO(
        Integer user_id,
        String user_name,
        List<FollowerDTO> followers
) {

}
