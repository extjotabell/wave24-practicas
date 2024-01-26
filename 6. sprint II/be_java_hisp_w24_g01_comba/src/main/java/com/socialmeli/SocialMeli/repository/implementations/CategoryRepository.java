package com.socialmeli.SocialMeli.repository.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.entity.Category;
import com.socialmeli.SocialMeli.repository.interfaces.ICategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {


    private List<Category> listCategories = new ArrayList<>();

    public CategoryRepository() throws IOException {
        loadDataBase();
    }


    @Override
    public Category findByIdOrCreate(CategoryPostRequestDTO categoryDTO) {
        return this.findById(categoryDTO.category_id()).orElseGet(() -> this.create(
                new Category(
                        categoryDTO.category_id(),
                        categoryDTO.category_name()
                )
        ));
    }

    @Override
    public Category create(Category category) {
        this.listCategories.add(category);
        return category;
    }

    @Override
    public Boolean remove(Category category) {
        return null;
    }

    @Override
    public Optional<Category> update(Category category) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return listCategories.stream().filter(category -> category.getId().equals(id)).findFirst();
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Category> categories;
        file= ResourceUtils.getFile("classpath:json/categories.json");
        categories= objectMapper.readValue(file, new TypeReference<>() {
        }) ;
        listCategories = categories;
    }
}
