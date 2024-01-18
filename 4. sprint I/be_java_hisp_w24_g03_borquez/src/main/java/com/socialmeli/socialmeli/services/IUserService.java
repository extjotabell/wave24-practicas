package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.*;

import java.util.List;

import com.socialmeli.socialmeli.entities.User;

import java.util.ArrayList;

public interface IUserService {
    UserFollowerDto getFollowers(Integer userId, String order);

    List<UserDto> getAllUsers();

    List<UserTotalDto> getAllUsersWithFollow();
    UserFollowersDto getTotalFollowers(Integer userId);
    ResponseDto follow(Integer userId, Integer userIdToFollow);
    ResponseDto unfollow(Integer userId, Integer userIdToFollow);
    UserFollowedDto listFollowed(Integer userId, String order);

    ResponseDto deleteById(Integer id);
}
