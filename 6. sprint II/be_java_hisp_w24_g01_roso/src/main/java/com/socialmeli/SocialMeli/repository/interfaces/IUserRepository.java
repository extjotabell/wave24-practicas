package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.User;

import java.util.Optional;


public interface IUserRepository{

    User getFollowers(Integer id);
    Optional<User> getFollowedUsers(Integer userId, Integer idToFollow);
    User create(User user);
    Optional<User> findById(Integer id);

    boolean userExists(int id);
}
