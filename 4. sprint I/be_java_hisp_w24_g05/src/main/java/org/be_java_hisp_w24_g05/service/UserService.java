package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.CountFollowersDto;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.NotFoundException;

import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;

import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public CountFollowersDto searchUserFollowers(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return userToCountFollowersDTO(user);
    }


    // Posts of followed users by user id from last 2 weeks sorted by date
    //in case none found throw not found exception
    public List<Post> recentPostsOfFollowedUsers(int userId, String order){
        try {
            return userRepository.recentPostsOfFollowedUsers(userId, order);
        }
        catch (Exception e) {
            throw new NotFoundException("User not found");
        }
    }


    @Override
    public UserFollowedDto followUser(int userId, int userIdToFollow) {
        User user = this.userRepository.addFollower(userId, userIdToFollow);
        return userToUserFollowedDTO(user);
    }

    @Override
    public UserFollowedDto unfollowUser(int userId, int userIdToUnfollow) {
        User user = this.userRepository.removeFollower(userId, userIdToUnfollow);
        return userToUserFollowedDTO(user);
    }
    @Override
    public List<UserFollowersDto> searchUserFollowers(Integer userId, String order) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        List<User> users= userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found")
        ).getFollowers();
        if(order.equals("name_asc")){
            users.sort(Comparator.comparing(User::getUserName));
        }else if(order.equals("name_desc")){
            users.sort(Comparator.comparing(User::getUserName).reversed());
        }
        return Collections.singletonList(convertUserFollowersToDto(user, users.stream()
                .map(this::convertUserToDto)
                .collect(Collectors.toList())));

    }

    public List<UserFollowedByDto> getSellerFollowedByUser(Integer userId, String order) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        List<User> followedList = user.getFollowed();
        if (followedList.isEmpty()) throw new NotFoundException("User ID: " + userId + " doesn't follow any seller.");
        if(order.equals("name_asc")){
            followedList.sort(Comparator.comparing(User::getUserName));
        }else if(order.equals("name_desc")){
            followedList.sort(Comparator.comparing(User::getUserName).reversed());
        }

        return Collections.singletonList(convertUserFollowedToDto(user, followedList.stream()
                .map(this::convertUserToDto)
                .collect(Collectors.toList())));

    }
    private UserDto convertUserToDto(User u){
        return new UserDto(
                u.getUserId(),
                u.getUserName()
        );
    }

    private UserFollowersDto convertUserFollowersToDto(User u,List<UserDto> users){
        return new UserFollowersDto(
                u.getUserId(),
                u.getUserName(),
                users
        );
    }

    private UserFollowedByDto convertUserFollowedToDto(User u,List<UserDto> users){
        return new UserFollowedByDto(
                u.getUserId(),
                u.getUserName(),
                users
        );
    }

    private UserFollowedDto userToUserFollowedDTO(User user) {
        return new UserFollowedDto(
                user.getUserId(),
                user.getUserName(),
                user.getFollowed().size()
        );
    }

    private CountFollowersDto userToCountFollowersDTO(User user) {
        return new CountFollowersDto(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }

}
