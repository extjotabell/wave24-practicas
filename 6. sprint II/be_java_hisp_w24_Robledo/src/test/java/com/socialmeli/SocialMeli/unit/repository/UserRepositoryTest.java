package com.socialmeli.SocialMeli.unit.repository;

import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import com.socialmeli.SocialMeli.repository.implementations.UserRepository;
import org.junit.jupiter.api.*;
import java.io.IOException;

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
