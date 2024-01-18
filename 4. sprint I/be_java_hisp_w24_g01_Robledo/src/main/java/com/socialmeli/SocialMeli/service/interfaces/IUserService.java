package com.socialmeli.SocialMeli.service.interfaces;


import com.socialmeli.SocialMeli.dto.*;

public interface IUserService {
  UserFollowersCountDTO getFollowersCount(Integer userId);
  Boolean unfollow(Integer userId, Integer userIdToUnfollow);
  UserFollowerDTO follow(Integer idFollower, Integer idFollowed);

  UserFollowerDTO getUserWithFollowers(Integer id, String order);

  boolean userExists(int id);
  UserFollowedDTO getFollowed(int userId, String order);

}
