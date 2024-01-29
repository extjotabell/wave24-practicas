package com.socialmeli.SocialMeli.service.interfaces;


import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowedDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;

public interface IUserService {
  UserFollowersCountDTO getFollowersCount(Integer userId);
  Boolean unfollow(Integer userId, Integer userIdToUnfollow);
  UserFollowerDTO follow(Integer idFollower, Integer idFollowed);

  UserFollowerDTO getUserWithFollowers(Integer id, String order);
  UserFollowedDTO getFollowed(int userId, String order);
}
