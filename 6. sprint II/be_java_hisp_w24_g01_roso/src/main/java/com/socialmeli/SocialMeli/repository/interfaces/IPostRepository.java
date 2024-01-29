package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.Post;

import java.util.List;

public interface IPostRepository{

    int findLastId();
    List<Post> getAllPostsById(Integer userId);
    Post create(Post post);
}
