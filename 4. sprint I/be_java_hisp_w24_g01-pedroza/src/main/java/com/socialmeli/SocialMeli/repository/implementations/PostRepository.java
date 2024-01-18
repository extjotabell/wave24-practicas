package com.socialmeli.SocialMeli.repository.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.Product;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        //validate the post exist
       var postSave=  listPosts.stream().filter(p -> p.getUserId().equals(post.getUserId()) && p.getProduct().getId().equals(post.getProduct().getId())).findFirst();
        if(postSave.isPresent()){
            throw new BadRequestException("Post already exists");
        }
        listPosts.add(post);

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
        return Optional.empty();
    }

    @Override
    public List<Post> getAll() {
        return null;
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
    public Integer productsPromo(Integer userId) {
        return (int)listPosts.stream().filter(e -> e.getUserId().equals(userId) && e.getHas_promo() != null).count();

    }

    @Override
    public List<Post> searchPostBycategory(String category, Double price) {

        return listPosts.stream().filter(e -> e.getCategory().getName().equals(category) && e.getPrice() <= price).toList();
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
