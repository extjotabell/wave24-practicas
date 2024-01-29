package com.socialmeli.SocialMeli.unit.repository;

import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.exception.UserNotFollowedException;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import com.socialmeli.SocialMeli.repository.implementations.UserRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import com.socialmeli.SocialMeli.utils.UserConstants;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


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

    @Test
    @DisplayName("Test that validates if the user is found")
    public void getFollowersNotFoundExceptionTest() {

        //Arrange
        Integer userId = 1019;

        //Act & Assert
        Assertions.assertThrows(
                UserNotFoundException.class,
                () -> userRepository.getFollowers(userId),"User found");

    }

    @Test
    @DisplayName("Test that validates if the user is not already following")
    public void getFollowedUsersOptionalEmptyTest() {

        //Arrange
        Integer userId = 101;
        Integer idToFollow = 104;
        Optional<User> expected = Optional.empty();

        //Act
        Optional<User> result = userRepository.getFollowedUsers(userId, idToFollow);

        //Act & Assert
        Assertions.assertEquals(expected, result, "List not empty");

    }

    @Test
    @DisplayName("Test that validates if the user is created")
    public void createTest() {

        //arrange
        User expected = UserConstants.USER1;

        //act
        User result = userRepository.create(UserConstants.USER1);

        //assert
        Assertions.assertEquals(expected, result, "The user is not created");
    }
}
