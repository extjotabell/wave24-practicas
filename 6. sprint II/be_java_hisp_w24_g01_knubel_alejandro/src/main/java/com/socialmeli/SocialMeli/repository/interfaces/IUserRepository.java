package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.User;

import java.util.Optional;


public interface IUserRepository extends ICrudRepository<User> {

    User getFollowers(Integer id);
    Optional<User> getFollowedUsers(Integer userId, Integer idToFollow);

    boolean userExists(int id);
}
