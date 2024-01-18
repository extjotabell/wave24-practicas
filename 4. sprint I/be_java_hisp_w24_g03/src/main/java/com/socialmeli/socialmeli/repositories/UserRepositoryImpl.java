package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.dto.UserDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.socialmeli.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    private ArrayList<User> users;

    public UserRepositoryImpl(){
        users = this.loadUserJson();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(user -> user.getUserId().equals(id)).findFirst();
    }

    @Override
    public ArrayList<User> findAll() {
        return this.users;
    }

    @Override
    public ArrayList<User> loadUserJson() {
        ArrayList<User> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).registerModule(new JavaTimeModule());
        TypeReference<ArrayList<User>> typeReference = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/user.json");
            data = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<User> listFollowed(Integer userId) {

        User user = this.findById(userId).orElse(null);

        return (user != null && user.getFollowed() != null) ? user.getFollowed() : new ArrayList<>();
    }

}
