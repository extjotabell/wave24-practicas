package org.socialmeli.be_java_hisp_w24_g04.repository;

import org.socialmeli.be_java_hisp_w24_g04.model.Post;

import java.util.Optional;

public interface IPostRepository extends ICrudRepository<Post>{
    Optional<Post> getPostByProductId(Integer productId);
}
