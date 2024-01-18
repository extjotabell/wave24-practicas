package org.be_java_hisp_w24_g05.repository;

import org.be_java_hisp_w24_g05.entity.FavoritePost;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.PromoPost;

import java.util.List;

public interface IPostRepository extends ICrudRepository<Post> {

    FavoritePost getFavoritePost(int postId, int userId);

    FavoritePost saveFavoritePost(FavoritePost favoritePost);

    List<Post> getFavoritePosts(int userId);
}
