package com.mercadolibre.be_java_hisp_w24_g02.repository.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private List<User> users;

    public UserRepositoryImpl() {
        this.users = loadData();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public User update(User user)
    {
        users = users.stream().map(user1 -> {
            if (user1.getId().equals(user.getId())) {
                return user;
            } else {
                return user1;
            }
        }).toList();

        return user;
    }

    @Override
    public void delete(Integer id) {

    }

    private List<User> loadData(){
        ArrayList<User> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<User>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/users.json");
            data = objectMapper.readValue(file, typeRef);
            createRelationships(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void createRelationships(ArrayList<User> data) {
        for (User user : data) {
            user.setFollowers(new ArrayList<>());
            user.setFollowed(new ArrayList<>());
        }

        for (User user : data) {
            createRelationships(data, user);
        }
    }

    private void createRelationships(ArrayList<User> data, User user) {
        List<Integer> followersIds = user.getFollowersIds();
        List<Integer> followedIds = user.getFollowedIds();

        for (Integer followerId : followersIds) {
            User follower = data.stream().filter(user1 -> user1.getId().equals(followerId)).findFirst().orElse(null);
            if (follower != null) {
                user.getFollowers().add(follower);
            }
        }

        for (Integer followedId : followedIds) {
            User followed = data.stream().filter(user1 -> user1.getId().equals(followedId)).findFirst().orElse(null);
            if (followed != null) {
                user.getFollowed().add(followed);
            }
        }

    }
}
