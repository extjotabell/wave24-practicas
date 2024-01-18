package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;

import java.util.List;


import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.dto.UserFollowersDto;

import org.be_java_hisp_w24_g05.dto.CountFollowersDto;

public interface IUserService {

    List<UserFollowersDto> searchUserFollowers(Integer userId, String order);

    List<UserFollowedByDto> getSellerFollowedByUser(Integer userId, String order);

    List<Post> recentPostsOfFollowedUsers(int userId, String order);

    UserFollowedDto followUser(int userId, int userIdToFollow);

    UserFollowedDto unfollowUser(int userId, int userIdToUnfollow);

    CountFollowersDto searchUserFollowers(Integer userId);
}
