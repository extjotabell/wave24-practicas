package com.socialmeli.SocialMeli.dto.responseDTO;

public record UserFollowersCountDTO(
      Integer user_id,
      String user_name,
      Integer followers_count
){
}
