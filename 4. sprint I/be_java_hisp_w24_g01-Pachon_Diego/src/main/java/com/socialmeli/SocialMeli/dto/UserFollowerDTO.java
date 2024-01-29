package com.socialmeli.SocialMeli.dto;

import java.util.List;

public record UserFollowerDTO(
        Integer user_id,
        String user_name,
        List<UserDTO> followers
) {

}
