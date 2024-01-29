package org.be_java_hisp_w24_g05.common;

import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.User;

import java.util.List;

public class ModelMapper {

    public UserDto convertUserToDto(User u){
        return new UserDto(
                u.getUserId(),
                u.getUserName()
        );
    }

    public UserFollowersDto convertUserFollowersToDto(User u, List<UserDto> users){
        return new UserFollowersDto(
                u.getUserId(),
                u.getUserName(),
                users
        );
    }

    public UserFollowedByDto convertUserFollowedToDto(User u, List<UserDto> users){
        return new UserFollowedByDto(
                u.getUserId(),
                u.getUserName(),
                users
        );
    }

    public UserFollowedDto userToUserFollowedDTO(User user) {
        return new UserFollowedDto(
                user.getUserId(),
                user.getUserName(),
                user.getFollowed().size()
        );
    }

    public CountFollowersDto userToCountFollowersDTO(User user) {
        return new CountFollowersDto(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }
}
