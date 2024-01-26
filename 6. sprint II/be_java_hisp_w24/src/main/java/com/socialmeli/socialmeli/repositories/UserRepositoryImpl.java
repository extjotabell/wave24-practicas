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
        if (user.getUserId()==null)
            user.setUserId(users.size()+1);

        if (users.add(user))
            return user;

        return null;
    }

    @Override
    public User update(User user) {
        Optional<User> foundUser = users.stream().filter(
                u -> u.getUserId().equals(user.getUserId())
        ).findFirst();

        if (foundUser.isEmpty())
            return null;

        foundUser.ifPresent(u -> users.set(users.indexOf(u), user));

        return user;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.users.removeIf(user -> user.getUserId().equals(id));
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
