package org.socialmeli.be_java_hisp_w24_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository{
    private List<Post> postRepository;
    private String jsonFile = "classpath:data/posts.json";

    public PostRepository() {
        this.postRepository = loadPosts();
    }

    private ArrayList<Post> loadPosts() {
        ArrayList<Post> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Post>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile(this.jsonFile);
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Post save(Post entity) {
        if (entity == null)
            return null;

        if (postRepository == null)
            postRepository = new ArrayList<>();

        postRepository.add(entity);

        return entity;
    }

    @Override
    public Post remove(Integer id) {
        var postToDelete = postRepository
                .stream()
                .filter(post -> post.getPostId().equals(id))
                .findFirst()
                .orElse(null);

        if (postToDelete == null)
            return null;

        postRepository.remove(postToDelete);

        return postToDelete;
    }

    @Override
    public Optional<Post> get(Integer id) {
        return postRepository
                .stream()
                .filter(post -> post.getPostId().equals(id))
                .findFirst();
    }

    @Override
    public List<Post> findAll() {
        return postRepository;
    }

    @Override
    public Post update(Post entity) {
        postRepository = postRepository
                .stream()
                .map(post -> post.getPostId().equals(entity.getPostId()) ? entity : post).toList();

        return entity;
    }
}
