package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.entities.Post;

import java.util.ArrayList;
import java.util.List;

public interface IPostRepository extends ICrudRepository<Post>{
    ArrayList<Post> loadPostJson();
    List<Post> findByUserId(Integer userId);
}
