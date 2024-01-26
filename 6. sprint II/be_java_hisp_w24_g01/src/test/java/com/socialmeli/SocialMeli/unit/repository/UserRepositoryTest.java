package com.socialmeli.SocialMeli.unit.repository;

import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.exception.UserNotFollowedException;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import com.socialmeli.SocialMeli.repository.implementations.UserRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    public UserRepositoryTest() throws IOException {
    }

    @Test
    @DisplayName("T-001 Not Found user to follow test")
    public void followUserBadTest() {

            //Arrange
            Integer userId = 101;
            Integer idToFollow = 10;

            //Act Assert
            Assertions.assertThrows(
                    UserNotFoundException.class,
                    () -> userRepository.getFollowedUsers(userId, idToFollow),"The follow correctly");

    }


}
