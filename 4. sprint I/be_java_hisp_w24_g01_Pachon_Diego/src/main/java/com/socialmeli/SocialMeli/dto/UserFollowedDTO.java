package com.socialmeli.SocialMeli.dto;

import java.util.List;

public record UserFollowedDTO(
       Integer user_id,
       String user_name,
       List<FollowerDTO> followed

) {}

