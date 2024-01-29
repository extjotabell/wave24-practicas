package org.socialmeli.be_java_hisp_w24_g04.unittest.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;

public class UserRepositoryTests {

    IUserRepository userRepository = new UserRepository();

    private User createUser(int id, String username) {
        return new User(id, username, new HashSet<>(), new HashSet<>());
    }

    @Test
    public void testFollow(){
        // Arrange
        User user1 = createUser(1, "user1");
        User user2 = createUser(2, "user2");
        userRepository.save(user1);
        userRepository.save(user2);

        // Act
        userRepository.addFollower(user1, user2);

        // Assert
        Assertions.assertTrue(user1.getFollowed().contains(new UserDTO(user2)));
        Assertions.assertTrue(user2.getFollowers().contains(new UserDTO(user1)));
    }

    @Test
    public void testUnfollow(){
        // Arrange
        User user1 = createUser(1, "user1");
        User user2 = createUser(2, "user2");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.addFollower(user1, user2);

        // Act
        userRepository.removeFollower(user1, user2);

        // Assert
        Assertions.assertFalse(user1.getFollowed().contains(new UserDTO(user2)));
        Assertions.assertFalse(user2.getFollowers().contains(new UserDTO(user1)));
    }

    @Test
    public void testFollowUserAlreadyFollowed(){
        // Arrange
        User user1 = createUser(1, "user1");
        User user2 = createUser(2, "user2");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.addFollower(user1, user2);

        // Act
        boolean followed = userRepository.addFollower(user1, user2);

        // Assert
        Assertions.assertTrue(user1.getFollowed().contains(new UserDTO(user2)));
        Assertions.assertTrue(user2.getFollowers().contains(new UserDTO(user1)));
        Assertions.assertFalse(followed);
    }

    @Test
    public void testUnfollowUserNotFollowed(){
        // Arrange
        User user1 = createUser(1, "user1");
        User user2 = createUser(2, "user2");
        userRepository.save(user1);
        userRepository.save(user2);

        // Act
        boolean unfollowed = userRepository.removeFollower(user1, user2);

        // Assert
        Assertions.assertFalse(user1.getFollowed().contains(new UserDTO(user2)));
        Assertions.assertFalse(user2.getFollowers().contains(new UserDTO(user1)));
        Assertions.assertFalse(unfollowed);
    }

    @Test
    public void testSaveUser() {
        // Arrange
        User user1 = createUser(1, "user1");
        // Act
        User savedUser = userRepository.save(user1);

        // Assert
        Assertions.assertEquals(user1, savedUser);
        Assertions.assertTrue(userRepository.findAll().contains(user1));
    }

    @Test
    public void testSaveNullUser() {
        // Arrange
        User user1 = null;
        // Act
        User savedUser = userRepository.save(user1);

        // Assert
        Assertions.assertNull(savedUser);
    }

    @Test
    public void testRemoveUser() {
        // Arrange
        User user1 = createUser(1, "user1");
        userRepository.save(user1);

        // Act
        User removedUser = userRepository.remove(user1.getUserId());

        // Assert
        Assertions.assertEquals(user1, removedUser);
        Assertions.assertFalse(userRepository.findAll().contains(user1));
    }

    @Test
    public void testRemoveNonExistentUser() {
        // Arrange
        User user1 = createUser(1, "user1");
        userRepository.save(user1);

        // Act
        User removedUser = userRepository.remove(2);

        // Assert
        Assertions.assertNull(removedUser);
        Assertions.assertTrue(userRepository.findAll().contains(user1));
    }

    @Test
    public void testGetUser() {
        // Arrange
        User user1 = createUser(1, "user1");
        userRepository.save(user1);

        // Act
        User foundUser = userRepository.get(user1.getUserId()).get();

        // Assert
        Assertions.assertEquals(user1, foundUser);
    }

    @Test
    public void testGetNonExistentUser() {
        // Arrange
        User user1 = createUser(1, "user1");
        userRepository.save(user1);

        // Act
        Optional<User> foundUser = userRepository.get(2);

        // Assert
        Assertions.assertTrue(foundUser.isEmpty());
    }

    @Test
    public void testFindAllUsers() {
        // Arrange
        User user1 = createUser(1, "user1");
        User user2 = createUser(2, "user2");
        userRepository.save(user1);
        userRepository.save(user2);

        // Act
        var users = userRepository.findAll();

        // Assert
        Assertions.assertTrue(users.contains(user1));
        Assertions.assertTrue(users.contains(user2));
    }

    @Test
    public void testUpdateUser() {
        // Arrange
        User user1 = createUser(1, "user1");
        userRepository.save(user1);

        // Act
        user1.setUsername("user2");
        User updatedUser = userRepository.update(user1);

        // Assert
        Assertions.assertEquals(user1, updatedUser);
        Assertions.assertTrue(userRepository.findAll().contains(user1));
    }

}
