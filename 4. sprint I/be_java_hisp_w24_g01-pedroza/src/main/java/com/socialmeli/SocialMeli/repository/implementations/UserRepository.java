package com.socialmeli.SocialMeli.repository.implementations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> listUsers = new ArrayList<>();

    public UserRepository() throws IOException {
        loadDataBase();
    }
    @Override
    public User create(User user) {
        listUsers.add(user);
        return user;
    }

    @Override
    public Boolean remove(User user) {
        return null;
    }

    @Override
    public Optional<User> update(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Integer id) {

        //Find a user given its ID
        //If the user is not found, return an empty optional

        return listUsers.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getFollowedUsers(Integer userId, Integer idToFollow) {

        if(userId.equals(idToFollow)){
            throw new BadRequestException("You can't follow yourself");
        }
        //find the users
        User follower = listUsers.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
        User userToFollow = listUsers.stream().filter(user -> user.getId().equals(idToFollow)).findFirst().orElse(null);

        if(follower==null || userToFollow==null){throw new BadRequestException("User not found");}

        //validate that the user is not already following
        boolean alreadyFollowing = follower.getFollowed().stream().anyMatch(u -> u.getId().equals(idToFollow));

        if(!alreadyFollowing){
            follower.getFollowed().add(userToFollow);
            userToFollow.getFollowers().add(follower);
            return follower;
        }else{
            throw new BadRequestException("You already follow this user");
        }

    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        // Registrar el módulo JavaTimeModule para manejar LocalDate
        objectMapper.registerModule(new JavaTimeModule());
        // Registrar el módulo ParameterNamesModule para manejar constructores con nombres de parámetros
        objectMapper.registerModule(new ParameterNamesModule());
        List<User> users ;
        file= ResourceUtils.getFile("classpath:json/users.json");
        users= objectMapper.readValue(file,new TypeReference<List<User>>(){});
        listUsers= users;
    }

    @Override
    public User getFollowers(Integer id) {
        User listUsersById = listUsers.stream()
                                .filter(user -> user.getId().equals(id))
                                .findFirst().get();
        return listUsersById;
    }

    @Override
    public boolean userExists(int id) {
        return listUsers.stream().anyMatch(u -> u.getId() == id);
    }
}
