package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.get(id);
        if (user.isEmpty())
            throw new NotFoundException("User with id " + id + " not found");
        return user.get();
    }

    @Override
    public Integer getFollowersCount(Integer userId) {
        return this.getFollowers(userId).size();
    }

    @Override
    public Set<UserDTO> getFollowers(Integer userId) {
        User user = this.findById(userId);
        return user.getFollowers();
    }

    @Override
    public Set<UserDTO> getFollowed(Integer userId) {
        User user = this.findById(userId);
        return user.getFollowed();
    }

    @Override
    public boolean follow(Integer userId, Integer userIdToFollow) {
        User user = this.findById(userId);
        User userToFollow = this.findById(userIdToFollow);

        return userRepository.addFollower(user, userToFollow);
    }

    @Override
    public boolean unfollow(Integer userId, Integer userIdToUnfollow) {
        User user = this.findById(userId);
        User userToUnfollow = this.findById(userIdToUnfollow);

        return userRepository.removeFollower(user, userToUnfollow);
    }
}
