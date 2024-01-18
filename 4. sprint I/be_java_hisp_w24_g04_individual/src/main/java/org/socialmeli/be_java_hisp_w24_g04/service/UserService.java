package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowersDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowedDTO;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserFollowersDTO getFollowers(Integer userId) {

        Optional<User> foundUser= userRepository.get(userId);

        if(foundUser.isEmpty()) throw new NotFoundException("No se encontró el usuario con id " + userId);

        return new UserFollowersDTO(
                foundUser.get().getUserId(),
                foundUser.get().getUsername(),
                foundUser.get().getFollowers());
    }


    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.get(id);
        if(user.isEmpty())
            throw new NotFoundException("El usuario no existe");
        return user.get();
    }

    @Override
    public UserFollowedDTO getUserFollowedDTO(User user) {
        return new UserFollowedDTO(user.getUserId(), user.getUsername(), user.getFollowed());
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        userRepository.follow(userId, userIdToFollow);
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        userRepository.unfollow(userId, userIdToUnfollow);
    }
}
