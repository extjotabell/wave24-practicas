package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.User;


public interface IUserRepository extends ICrudRepository<User> {

    User getFollowers(Integer id);
    User getFollowedUsers(Integer userId,Integer idToFollow);


    boolean userExists(int id);

}
