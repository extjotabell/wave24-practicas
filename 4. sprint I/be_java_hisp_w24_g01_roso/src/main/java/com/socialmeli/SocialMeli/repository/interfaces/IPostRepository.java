package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.Post;

import java.util.List;

public interface IPostRepository extends ICrudRepository<Post>{

    int findLastId();

    List<Post> getAllPostsById(Integer userId);
    List<Post> getQuantityPostsPromo(Integer id);

    List<Post> deleteMyPostById(Integer postId, Integer userId);
    List<Post> getMyPostsByHigherPrice(Integer userId);
}
