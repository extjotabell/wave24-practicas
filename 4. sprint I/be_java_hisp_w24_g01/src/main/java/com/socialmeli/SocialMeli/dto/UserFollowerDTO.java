package com.socialmeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserFollowerDTO(
        Integer user_id,
        String user_name,
        List<FollowerDTO> followers
) {

}
