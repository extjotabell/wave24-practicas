package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.PromoPost;

import java.util.List;

public interface IPostRepository extends ICrudRepository<Post>{

    int findLastId();

    //For promo post
    PromoPost createPromoPost(PromoPost post);

    List<Post> getAllPostsByIdNoTimeValidation(Integer userId);

    List<Post> getAllPostsById(Integer userId);

    Post findByIdPost(Integer id);
}
