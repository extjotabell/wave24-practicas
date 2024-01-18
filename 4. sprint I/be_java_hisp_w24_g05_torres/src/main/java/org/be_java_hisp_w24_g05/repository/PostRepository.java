package org.be_java_hisp_w24_g05.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.be_java_hisp_w24_g05.entity.FavoritePost;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.PromoPost;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
@AllArgsConstructor
public class PostRepository implements IPostRepository {

    private ArrayList<Post> posts;
    private ArrayList<FavoritePost> favoritePosts;

    @Autowired
    private IUserRepository userRepository;

    public PostRepository() {

        this.posts = new ArrayList<>();
        this.favoritePosts = new ArrayList<>();
        this.loadData();
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Post> findById(Integer id) {
        Post post = this.posts.stream().filter(p -> p.getPostId().equals(id)).findFirst().orElseThrow(() -> new BadRequestException("Post not found"));
        return Optional.of(post);
    }

    @Override
    public ArrayList<Post> findAll() {
        return null;
    }

    private ArrayList<Post> loadData() {
        this.userRepository = new UserRepository();
        this.userRepository.findAll().forEach(user -> {
            this.posts.addAll(user.getPosts());
        });
        System.out.println("Posts loaded: " + this.posts.size());
        return this.posts;
    }

    @Override
    public FavoritePost getFavoritePost(int postId, int userId) {

        return this.favoritePosts
                .stream()
                .filter(favoritePost -> favoritePost.getPostId() == postId && favoritePost.getUserId() == userId)
                .findFirst().orElse(null);
    }

    @Override
    public FavoritePost saveFavoritePost(FavoritePost favoritePost) {
        this.favoritePosts.add(favoritePost);
        return favoritePost;
    }

    @Override
    public List<Post> getFavoritePosts(int userId) {

        List<Post>  posts = this.favoritePosts
                .stream()
                .filter(favoritePost -> favoritePost.getUserId() == userId).map(favoritePost -> this.posts.stream()
                        .filter(post -> post.getPostId() == favoritePost.getPostId()).findFirst().orElse(null))
                .toList();
        if(posts.isEmpty()) {
            throw new BadRequestException("No favorite posts found");
        }

        return posts;
    }
}
