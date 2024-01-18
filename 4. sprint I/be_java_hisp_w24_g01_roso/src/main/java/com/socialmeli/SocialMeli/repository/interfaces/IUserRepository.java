package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.User;

import java.util.Optional;


public interface IUserRepository extends ICrudRepository<User> {

    Optional<User> getFollowers(Integer id);
    User getFollowedUsers(Integer userId,Integer idToFollow);

    boolean userExists(int id);
}
