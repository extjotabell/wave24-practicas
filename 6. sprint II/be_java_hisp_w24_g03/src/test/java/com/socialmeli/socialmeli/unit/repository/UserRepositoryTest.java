package com.socialmeli.socialmeli.unit.repository;

import com.socialmeli.socialmeli.entities.User;
import com.socialmeli.socialmeli.repositories.IUserRepository;
import com.socialmeli.socialmeli.repositories.UserRepositoryImpl;
import com.socialmeli.socialmeli.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest {

    IUserRepository userRepository = new UserRepositoryImpl();

    UserUtils userUtils = new UserUtils();
    @Test
    @DisplayName("Test to add a new user")
    void saveTest(){
        // Act
        var result = userRepository.save(userUtils.getNEW_USER());

        // Assert
        Assertions.assertEquals(userUtils.getNEW_USER(), result, "User was not saved");
    }

    @Test
    @DisplayName("Test to update an user")
    void updateTest(){
        // Arrange
        User expected = userUtils.getUSER_1115();
        expected.setUserName("User 1115");

        // Act
        var result = userRepository.update(expected);

        // Assert
        Assertions.assertEquals(expected, result, "User was not updated");
    }

    @Test
    @DisplayName("Test to delete an user")
    void deleteTest(){
        // Arrange
        int idParam = 1115;

        // Act
        var result = userRepository.deleteById(idParam);

        // Assert
        Assertions.assertTrue(result, "User was not delete");
    }

    @Test
    @DisplayName("Test to find an user by id")
    void findByIdTest(){
        // Arrange
        int idParam = 1115;
        Optional<User> expected = Optional.of(userUtils.getUSER_1115());

        // Act
        var result = userRepository.findById(idParam);

        // Assert
        Assertions.assertEquals(expected, result, "User was not found");
    }

    @Test
    @DisplayName("Test to find all user")
    void findAllTest(){
        // Arrange
        int expected = 3;

        // Act
        int result = userRepository.findAll().size();

        // Assert
        Assertions.assertEquals(expected, result, "Users were not found");
    }

    @Test
    @DisplayName("Test to find a followed list by id")
    void listFollowedTest(){
        // Arrange
        int idParam = 1115;
        List<User> expected = userUtils.getUSER_1115().getFollowed();

        // Act
        var result = userRepository.listFollowed(idParam);

        // Assert
        Assertions.assertEquals(expected, result, "List was not found");
    }

    @Test
    @DisplayName("Test to find a followed list by non-existent id")
    void listFollowedByNonExistentIdTest(){
        // Arrange
        int idParam = 1010;
        List<User> expected = new ArrayList<>();

        // Act
        var result = userRepository.listFollowed(idParam);

        // Assert
        Assertions.assertEquals(expected, result, "List was not found");
    }
}
