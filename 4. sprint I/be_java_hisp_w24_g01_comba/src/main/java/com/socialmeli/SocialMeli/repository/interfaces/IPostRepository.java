package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.Post;

import java.util.List;

public interface IPostRepository extends ICrudRepository<Post>{

    int findLastId();

    List<Post> getAllPostsByUserIdLastTwoWeeks(Integer userId);

    List<Post> findAllByUserId(Integer userId);
}
