package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.ResponseDto;
import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.dto.UserFollowerDto;
import java.util.List;
import com.socialmeli.socialmeli.dto.UserFollowedDto;
import com.socialmeli.socialmeli.dto.UserFollowersDto;


public interface IUserService {
    UserFollowerDto getFollowers(Integer userId, String order);

    List<UserDto> getAllUsers();
    UserFollowersDto getTotalFollowers(Integer userId);
    ResponseDto follow(Integer userId, Integer userIdToFollow);
    ResponseDto unfollow(Integer userId, Integer userIdToFollow);
    UserFollowedDto listFollowed(Integer userId, String order);
}
