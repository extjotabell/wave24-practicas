package com.socialmeli.SocialMeli.repository.implementations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
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

    public User create(User user) {
        listUsers.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Integer id) {

        //Find a user given its ID
        //If the user is not found, return an empty optional
        return listUsers.stream().filter(user -> user.getId().equals(id)).findFirst();
    }


    @Override
    public Optional<User> getFollowedUsers(Integer userId, Integer idToFollow) {

        //find the users
        User follower = listUsers.stream().filter(user -> user.getId().equals(userId)).findFirst().orElseThrow(() -> new UserNotFoundException("Follower not found"));
        User userToFollow = listUsers.stream().filter(user -> user.getId().equals(idToFollow)).findFirst().orElseThrow(() -> new UserNotFoundException("Follower not found"));
        //validate that the user is not already following
        boolean alreadyFollowing = follower.getFollowed().stream().anyMatch(u -> u.getId().equals(idToFollow));
        System.out.println(alreadyFollowing);
        if(!alreadyFollowing){
            follower.getFollowed().add(userToFollow);
            userToFollow.getFollowers().add(follower);
            return Optional.of(follower);
        }else{return Optional.empty();}

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
                                .findFirst().orElseThrow(
                        () -> new UserNotFoundException("User not found")
                );
        return listUsersById;
    }

    @Override
    public boolean userExists(int id) {
        return listUsers.stream().anyMatch(u -> u.getId() == id);
    }
}
