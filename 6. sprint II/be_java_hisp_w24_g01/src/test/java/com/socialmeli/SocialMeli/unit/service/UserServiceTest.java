package com.socialmeli.SocialMeli.unit.service;

import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;
import com.socialmeli.SocialMeli.utils.UserConstants;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import com.socialmeli.SocialMeli.service.implementations.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private boolean isValidateExceptionTest = false;
    public static final List<FollowerDTO> FOLLOWERSDTO = List.of(
            new FollowerDTO(102, "Bob Smith"),
            new FollowerDTO(103, "Charlie Brown"));
    public static final List<FollowerDTO> FOLLOWERSREVERSEDDTO = List.of(
            new FollowerDTO(103, "Charlie Brown"),
            new FollowerDTO(102, "Bob Smith")
    );
    public static final UserFollowerDTO USER1DTO = new UserFollowerDTO(
            101,
            "Alice Johnson",
            FOLLOWERSDTO);
    public static final UserFollowerDTO USER1FOLLOWERSREVERSEDTO = new UserFollowerDTO(
            101,
            "Alice Johnson",
            FOLLOWERSREVERSEDDTO);


    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("T-001 Follow user service test")
    public void followUserGoodTest() {
        // Arrange
        Integer userId = 101;
        Integer userIdToFollow = 102;

        //construct the user to return
        UserFollowerDTO userFollowerDTO = new UserFollowerDTO(userId, "Alice Johnson",
                List.of(new FollowerDTO(104, "David Williams"),
                        new FollowerDTO(105, "Eva Martinez"),
                        new FollowerDTO(userIdToFollow, "Bob Smith")
                ));

        //construct the user received from the repository
        User user = UserConstants.USER1;
        user.getFollowed().add(UserConstants.USER2);

        // Act
        Mockito.when(userRepository.getFollowedUsers(userId, userIdToFollow)).thenReturn(Optional.of(user));
        var result = userService.follow(userId, userIdToFollow);

        // Assert
        Assertions.assertEquals(userFollowerDTO, result);

    }


    @Test
    @DisplayName("T-001 Follow self user test")
    public void followUserBadTest() {
        // Arrange
        Integer userId = 101;
        Integer userIdToFollow = 101;

        // Act Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.follow(userId, userIdToFollow), "The user was not followed correctly");

    }

    @Test
    @DisplayName("T-001 Follow user  already follow  test")
    public void followUserBadTest2() {
        // Arrange
        Integer userId = 101;
        Integer userIdToFollow = 102;


        Mockito.when(userRepository.getFollowedUsers(userId, userIdToFollow)).thenReturn(Optional.empty());
        // Act Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.follow(userId, userIdToFollow), "The user was not followed correctly");
    }

    @Test
    @DisplayName("T-0002 When unfollowing an existing user, then unfollow successfully")
    public void unfollowExistingUser() {
        // Arrange
        // Create user and userToUnfollow objects to simulate existing users in the system.
        User user = UserConstants.USER1;
        User userToUnfollow = UserConstants.USER4;

        // Mock the userRepository's response to return these users when their IDs are searched.
        Mockito.when(userRepository.findById(101)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(104)).thenReturn(Optional.of(userToUnfollow));

        // Act
        // Call the unfollow method and store the result (true/false).
        boolean result = userService.unfollow(101, 104);

        // Assert
        // Check if the unfollow operation returned true indicating success.
        Assertions.assertTrue(result, "Unfollow operation should return true");
        // Ensure userToUnfollow is removed from user's followed list.
        Assertions.assertFalse(user.getFollowed().contains(userToUnfollow), "User should be removed from followed list");
        // Ensure user is removed from userToUnfollow's followers list.
        Assertions.assertFalse(userToUnfollow.getFollowers().contains(user), "User should be removed from followers list of userToUnfollow");
    }


    @Test
    @DisplayName("T-0002 When unfollowing a non-existing user, then handle gracefully")
    public void unfollowNonExistingUser() {
        // Arrange
        int userId = 101; // Existing user ID
        int nonExistentUserId = 999; // Non-existing user ID

        // Create a user object to simulate an existing user in the system.
        User user = UserConstants.USER1;
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act & Assert
        // Assert that a UserNotFoundException is thrown when trying to unfollow a non-existing user.
        Assertions.assertThrows(
                UserNotFoundException.class,
                () -> userService.unfollow(userId, nonExistentUserId),
                "Unfollowing a non-existing user should throw UserNotFoundException"
        );
    }

    //T-0003 y T-0004
    private void validateAlphabeticalOrderTest(int userId, String order, boolean isAscendingOrder) {

        //arrange
        UserFollowerDTO expected = isAscendingOrder ? USER1DTO : USER1FOLLOWERSREVERSEDTO;

        //act
        Mockito.when(userRepository.getFollowers(userId)).thenReturn(UserConstants.USER1);

        if (isValidateExceptionTest) {
            //assert
            Assertions.assertThrows(
                    BadRequestException.class,
                    () -> userService.getUserWithFollowers(userId, order)
            );
        } else {
            //act
            UserFollowerDTO result = userService.getUserWithFollowers(userId, order);

            //assert
            Assertions.assertEquals(expected, result, "The value of the 'order' parameter is incorrect");
        }
    }

    @Test
    @DisplayName("T-0003 Test that validates the value of the alphabetical order parameter for a value null")
    public void validateAlphabeticalOrderExceptionNullParameterTest() {
        //arrange
        isValidateExceptionTest = true;
        validateAlphabeticalOrderTest(101, null, true);
    }

    @Test
    @DisplayName("T-0003 Test that validates the value of the alphabetical order parameter for a value empty")
    public void validateAlphabeticalOrderExceptionEmptyParameterTest() {
        //arrange
        isValidateExceptionTest = true;
        validateAlphabeticalOrderTest(101, " ", true);
    }

    @Test
    @DisplayName("T-0003 Test that validates the value of the alphabetical order parameter for a value other than 'name_asc' or 'name_desc'")
    public void validateAlphabeticalOrderExceptionBadParameterTest() {
        //arrange
        isValidateExceptionTest = true;
        validateAlphabeticalOrderTest(101, "mal", true);
    }

    @Test
    @DisplayName("T-0004 Test that validates the correct functionality of alphabetical order ascending")
    public void getUserWithFollowersAscTest() {
        //arrange
        validateAlphabeticalOrderTest(101, "name_asc", true);
    }

    @Test
    @DisplayName("T-0004 Test that validates the correct functionality of alphabetical order descending")
    public void getUserWithFollowersDescTest() {
        //arrange
        validateAlphabeticalOrderTest(101, "name_desc", false);
    }


    @Test
    @DisplayName("T-0007 Verify that the number of followers of a certain user is correct")
    public void getFollowersCountTest() {
        // Arrange
        int userId = 101;
        String userName = "Alice Johnson";
        ArrayList<User> followers = new ArrayList<>();
        followers.add(UserConstants.USER2);
        followers.add(UserConstants.USER3);
        User user = UserConstants.USER1;

        UserFollowersCountDTO expected = new UserFollowersCountDTO(userId, userName, followers.size());

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        var result = userService.getFollowersCount(userId);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0007 Verify that UserNotFoundException is thrown when user is not found")
    public void getFollowersCountTestUserNotFoundException() {
        // Arrange
        int userId = 10132;

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Assert
        Assertions.assertThrows(
                UserNotFoundException.class,
                () -> userService.getFollowersCount(userId)
        );
    }




}

