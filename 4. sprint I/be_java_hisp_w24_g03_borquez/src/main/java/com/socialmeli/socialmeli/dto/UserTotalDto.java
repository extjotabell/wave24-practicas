package com.socialmeli.socialmeli.dto;

import java.util.List;

public record UserTotalDto(Integer userId, String userName, List<UserDto> followers, List<UserDto> followed) {
}
