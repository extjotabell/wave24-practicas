package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.socialmeli.entities.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    private ArrayList<Post> posts;

    public PostRepositoryImpl() {
        this.posts = this.loadPostJson();
    }

    @Override
    public Post save(Post post) {
        if(this.posts.add(post)){
            return post;
        }
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
        return posts.stream().filter(post -> post.getUserId().equals(id)).findFirst();
    }

    @Override
    public ArrayList<Post> findAll() {
        return this.posts;
    }

    @Override
    public ArrayList<Post> loadPostJson() {
        ArrayList<Post> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).registerModule(new JavaTimeModule());
        TypeReference<ArrayList<Post>> typeReference = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/post.json");
            data = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
