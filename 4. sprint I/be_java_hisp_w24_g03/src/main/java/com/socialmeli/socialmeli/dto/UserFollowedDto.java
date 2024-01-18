package com.socialmeli.socialmeli.dto;

import java.util.List;

public record UserFollowedDto(Integer user_id, String use_name, List<UserDto> followed) {
}
