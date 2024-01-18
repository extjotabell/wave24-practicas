package com.socialmeli.socialmeli.dto;

import java.util.List;

public record UserInfoDto(
        Integer user_id,
        String user_name,
        List<UserDto> followers,
        List<UserDto> followed
) {
}