package org.socialmeli.be_java_hisp_w24_g04.unittest.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
@SpringBootTest
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
}
