package com.socialmeli.SocialMeli.repository.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.exception.NotFoundException;
import com.socialmeli.SocialMeli.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {


    private List<Post> listPosts = new ArrayList<>();


    public PostRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public int findLastId() {
        return this.listPosts.stream().mapToInt(Post::getId).max().orElse(0);
    }

    @Override
    public Post create(Post post) {
        this.listPosts.add(post);
        return post;
    }

    @Override
    public Boolean remove(Post post) {
        return null;
    }

    @Override
    public Optional<Post> update(Post post) {
        return Optional.empty();
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return listPosts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    @Override
    public List<Post> getAll() {
        return listPosts;
    }

    public List<Post> getAllPostsById(Integer userId) {
        var latestPost = this.listPosts.stream()
                .filter(e-> e.getUserId().equals(userId)
                        && ((e.getDate()).isAfter(LocalDate.now().minusWeeks(2))
                        || (e.getDate()).isEqual(LocalDate.now()))
                ).collect(Collectors.toList());

        return (List<Post>) latestPost;
    }

    @Override
    public List<Post> getQuantityPostsPromo(Integer id) {
        return listPosts.stream()
                .filter(post -> Objects.equals(post.getUserId(), id) && Boolean.TRUE.equals(post.getHasPromo()))
                .toList();
    }

    @Override
    public List<Post> deleteMyPostById(Integer postId, Integer userId) {
        if(!listPosts.removeIf(post -> post.getId().equals(postId)))
            throw new NotFoundException("The post id: " + postId + " not found, post not deleted");
        return listPosts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
    }
    @Override
    public List<Post> getMyPostsByHigherPrice(Integer userId) {
        return listPosts.stream()
                .filter(post -> post.getUserId().equals(userId))
                .sorted(Comparator.comparing(Post::getPrice).reversed())
                .collect(Collectors.toList());
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        // Registrar el módulo JavaTimeModule para manejar LocalDate
        objectMapper.registerModule(new JavaTimeModule());
        // Registrar el módulo ParameterNamesModule para manejar constructores con nombres de parámetros
        objectMapper.registerModule(new ParameterNamesModule());
        List<Post> posts ;
        file= ResourceUtils.getFile("classpath:json/posts.json");
        posts= objectMapper.readValue(file,new TypeReference<List<Post>>(){});
        listPosts= posts;
    }
}
