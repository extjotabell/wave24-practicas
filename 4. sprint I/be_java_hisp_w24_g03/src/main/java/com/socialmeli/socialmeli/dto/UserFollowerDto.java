package com.socialmeli.socialmeli.dto;

import java.util.List;

public record UserFollowerDto(Integer userId, String userName, List<UserDto> follower) {
}
