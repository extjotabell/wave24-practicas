package org.socialmeli.be_java_hisp_w24_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> userRepository;
    private String jsonFile = "classpath:data/users.json";

    public UserRepository() {
        this.userRepository = loadUsers();
    }

    private ArrayList<User> loadUsers() {
        ArrayList<User> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<User>> typeRef = new TypeReference<>() {
        };
        try {
            file = ResourceUtils.getFile(this.jsonFile);
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public User save(User entity) {
        if (entity == null)
            return null;

        userRepository.add(entity);

        return entity;
    }

    @Override
    public User remove(Integer id) {
        var productToDelete = userRepository
                .stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst()
                .orElse(null);

        if (productToDelete == null)
            return null;

        userRepository.remove(productToDelete);

        return productToDelete;
    }

    @Override
    public Optional<User> get(Integer id) {
        return userRepository
                .stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return userRepository;
    }

    @Override
    public User update(User entity) {
        userRepository = userRepository
                .stream()
                .map(user -> user.getUserId().equals(entity.getUserId()) ? entity : user).toList();

        return entity;
    }

    @Override
    public boolean addFollower(User user, User userToFollow) {
        try {
            user.getFollowed().add(new UserDTO(userToFollow.getUserId(), userToFollow.getUsername()));
            userToFollow.getFollowers().add(new UserDTO(user.getUserId(), user.getUsername()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeFollower(User user, User userToUnfollow) {
        try {
            user.getFollowed().removeIf(u -> u.user_id().equals(userToUnfollow.getUserId()));
            userToUnfollow.getFollowers().removeIf(u -> u.user_id().equals(user.getUserId()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
