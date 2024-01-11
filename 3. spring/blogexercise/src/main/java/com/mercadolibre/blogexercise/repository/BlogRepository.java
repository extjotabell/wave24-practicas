package com.mercadolibre.blogexercise.repository;

import com.mercadolibre.blogexercise.entity.BlogEntity;

import java.util.List;
import java.util.Optional;

public interface BlogRepository {
    public Integer create(BlogEntity blog);
    public List<BlogEntity> findAll();
    public Optional<BlogEntity> findById(Integer id);
}
