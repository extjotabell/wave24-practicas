package com.socialmeli.SocialMeli.dto.responseDTO;

import java.util.List;

public record UserFollowedDTO(
       Integer user_id,
       String user_name,
       List<UserDTO> followed

) {}

