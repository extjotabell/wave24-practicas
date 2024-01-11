package com.mercadolibre.blogexercise.repository;

import com.mercadolibre.blogexercise.entity.BlogEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private List<BlogEntity> blogs;

    public BlogRepositoryImpl() {
        this.blogs = new ArrayList<>();
    }

    @Override
    public Integer create(BlogEntity blog) {
        this.blogs.add(blog);
        return blog.getId();
    }

    @Override
    public List<BlogEntity> findAll() {
        return this.blogs;
    }

    @Override
    public Optional<BlogEntity> findById(Integer id) {
        return this.blogs.stream().filter(blogEntity -> blogEntity.getId().equals(id)).findFirst();
    }
}
