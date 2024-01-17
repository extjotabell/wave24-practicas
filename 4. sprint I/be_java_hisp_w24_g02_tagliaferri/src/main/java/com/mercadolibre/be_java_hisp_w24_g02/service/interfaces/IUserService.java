package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.*;


public interface IUserService {


    UserFollowersCountDTO getUserFollowersCount(Integer userId);
    void unfollowUser(UpdateToRelationshipsDTO followUserDTO);
    void followUser(UpdateToRelationshipsDTO followUserDTO);
    UserRelationshipsDTO getUserFollowers(Integer userId, String order);
    UserRelationshipsDTO getUserFollowed(Integer userId, String order);

    UserFollowedsPostsDTO getFollowedPost(Integer userId);


}
