package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.FollowUserDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserRelationshipsDTO;


public interface IUserService {


    UserFollowersCountDTO getUserFollowersCount(Integer userId);
    void unfollowUser(FollowUserDTO followUserDTO);
    void followUser(FollowUserDTO followUserDTO);
    UserRelationshipsDTO getUserFollowers(Integer userId, String order);
    UserRelationshipsDTO getUserFollowed(Integer userId, String order);

    UserFollowedsPostsDTO getFollowedPost(Integer userId);

}
