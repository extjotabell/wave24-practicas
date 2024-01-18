package org.socialmeli.be_java_hisp_w24_g04.repository;

import org.socialmeli.be_java_hisp_w24_g04.model.User;

public interface IUserRepository extends ICrudRepository<User> {
    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);
}
