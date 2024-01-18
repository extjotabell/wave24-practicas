package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.entities.User;
import com.socialmeli.socialmeli.exceptions.BadRequestException;
import com.socialmeli.socialmeli.mapper.Mapper;
import com.socialmeli.socialmeli.exceptions.BadRequestException;
import com.socialmeli.socialmeli.exceptions.NotFoundException;
import com.socialmeli.socialmeli.mapper.Mapper;
import com.socialmeli.socialmeli.repositories.IUserRepository;
import com.socialmeli.socialmeli.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    IUserRepository userRepository;
    Mapper mapper = new Mapper();

    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserFollowersDto getTotalFollowers(Integer userId) {
        if(Objects.isNull(userId))
            throw new BadRequestException("No ingreso correctamente el paramentro userId");

        User user = userRepository.findById(userId).orElse(null);
        if (Objects.isNull(user))
            throw new NotFoundException("No se encontro un usuario con el id " + userId);

        return new UserFollowersDto(userId, user.getUserName(), user.getFollowers().size());
    }

    @Override
    public ResponseDto follow(Integer userId, Integer userIdToFollow) {
        if(Objects.isNull(userId))
            throw new BadRequestException("No ingreso correctamente el paramentro userId");

        if(Objects.isNull(userIdToFollow))
            throw new BadRequestException("No ingreso correctamente el paramentro userIdToFollow");

        User user = this.userExists(userId);
        User userToFollow = this.userExists(userIdToFollow);

        // Verify if user already follows to userToFollow
        if (this.userIsFollowerOf(user, userToFollow))
            throw new BadRequestException("El usuario " + userId + " ya sigue al usuario " + userIdToFollow);

        // Set user as "follower" in userToFollow
        userToFollow.getFollowers().add(user);

        // Set userToFollow as "followed" in user
        user.getFollowed().add(userToFollow);

        return new ResponseDto("Follow exitoso");
    }

    public ResponseDto unfollow(Integer userId, Integer userIdToFollow) {
        User user = this.userExists(userId);
        User userToUnfollow = this.userExists(userIdToFollow);

        // Verify if user isn't a follower of userToUnfollow
        if (!this.userIsFollowerOf(user, userToUnfollow))
            throw new BadRequestException("El usuario " + userId + " no sigue al usuario " + userIdToFollow);

        // Remove user as "follower" in userToUnfollow
        userToUnfollow.getFollowers().removeIf(u -> u.getUserId().equals(user.getUserId()));

        // Remove userToUnfollow as "followed" in user
        user.getFollowed().removeIf(u -> u.getUserId().equals(userToUnfollow.getUserId()));
        return new ResponseDto("Unfollow exitoso");
    }

    @Override
    public UserFollowerDto getFollowers(Integer userId, String order) {
        User user = userRepository.findById(userId).orElse(null);

        if (Objects.isNull(user)){
            throw new BadRequestException("El usuario "  + userId +  " no existe.");
        }
        List<UserDto> followerList = sortFollower(user.getFollowers(),order);

        return new UserFollowerDto(user.getUserId(), user.getUserName(), followerList);
    }

    private List<UserDto> sortFollower(List<User> usersFollower, String order){
        switch(order){
            case "name_asc":
                return mapper.convertToUserDtoList(usersFollower.stream()
                        .sorted(Comparator.comparing(User::getUserName))
                        .collect(Collectors.toList()));
            case "name_desc":
                return mapper.convertToUserDtoList(usersFollower.stream()
                        .sorted(Comparator.comparing(User::getUserName).reversed())
                        .collect(Collectors.toList()));
            case "default":
                return mapper.convertToUserDtoList(usersFollower);
            default:
                throw new BadRequestException("Orden invalido");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll().stream().map(mapper::convertToUserDto).toList();
    }

    // Verify if user is a follower of userToFollow
    private Boolean userIsFollowerOf(User user, User userToFollow) {
        if (user.getUserId().equals(userToFollow.getUserId()))
            throw new BadRequestException("No puede realizar la acción a el mismo usuario");

        return user.getFollowed().stream().anyMatch(
                followed -> followed.getUserId().equals(userToFollow.getUserId())
        );
    }

    // Verify if a user exists by id
    private User userExists(Integer id) {
        var user = this.userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("El usuario " + id + " no existe");

        return user.get();
    }

    @Override
    public UserFollowedDto listFollowed(Integer userId, String order) {

        User user = userRepository.findById(userId).orElse(null);
        List<User> followed = userRepository.listFollowed(userId);
        List<UserDto> followedList = sortFollowed(followed,order);
        if (Objects.isNull(user))
            throw new NotFoundException("No se encontro un usuario con el id " + userId);

        return new UserFollowedDto(user.getUserId(), user.getUserName(), followedList);
    }

    private List<UserDto> sortFollowed(List<User> usersFollowed, String order){
        switch(order){
            case "name_asc":
                return mapper.convertToUserDtoList(usersFollowed.stream()
                        .sorted(Comparator.comparing(User::getUserName))
                        .collect(Collectors.toList()));
            case "name_desc":
                return mapper.convertToUserDtoList(usersFollowed.stream()
                        .sorted(Comparator.comparing(User::getUserName).reversed())
                        .collect(Collectors.toList()));
            case "default":
                return mapper.convertToUserDtoList(usersFollowed);
            default:
                throw new BadRequestException("Orden invalido");
        }
    }

}
