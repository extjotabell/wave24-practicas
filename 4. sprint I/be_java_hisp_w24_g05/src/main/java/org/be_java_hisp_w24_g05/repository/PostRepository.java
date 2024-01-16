package org.be_java_hisp_w24_g05.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.be_java_hisp_w24_g05.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
@AllArgsConstructor
public class PostRepository implements IPostRepository {

    private ArrayList<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
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
        return Optional.empty();
    }

    @Override
    public ArrayList<Post> findAll() {
        return null;
    }

}
