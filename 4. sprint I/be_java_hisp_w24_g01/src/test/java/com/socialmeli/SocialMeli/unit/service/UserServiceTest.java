package com.socialmeli.SocialMeli.unit.service;

import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowersCountDTO;
import com.socialmeli.SocialMeli.exception.UserNotFoundException;
import com.socialmeli.SocialMeli.dto.responseDTO.FollowerDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;
import org.assertj.core.api.Assert;
import com.socialmeli.SocialMeli.entity.Post;
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
  
    private final List<User> FOLLOWERS = new ArrayList<>();
    private final List<User> FOLLOWED = new ArrayList<>();
    private final List<Post> POSTS = new ArrayList<>();
    private final List<FollowerDTO> FOLLOWERSDTO = List.of(
            new FollowerDTO(102, "Bob Smith"),
            new FollowerDTO(103, "Charlie Brown"));
    private final List<FollowerDTO> FOLLOWERSREVERSEDDTO = List.of(
            new FollowerDTO(103, "Charlie Brown"),
            new FollowerDTO(102, "Bob Smith")
            );
    private final UserFollowerDTO USER1DTO = new UserFollowerDTO(
                101,
             "Alice Johnson",
            FOLLOWERSDTO);
    private final UserFollowerDTO USER1FOLLOWERSREVERSEDTO = new UserFollowerDTO(
            101,
            "Alice Johnson",
            FOLLOWERSREVERSEDDTO);

    private final User USER1 = new User(101, "Alice Johnson" ,FOLLOWERS, FOLLOWED, POSTS);
    private boolean isValidateExceptionTest = false;
  

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("T-0007 Verify that the number of followers of a certain user is correct")
    public void getFollowersCountTest(){
        // Arrange
        int userId = 101;
        String userName = "Alice Johnson";
        ArrayList<User> followers = new ArrayList<>();
        followers.add(new User(102, "Bob Smith", null,null,null));
        followers.add(new User(103, "Charlie Brown", null,null,null));
        User user = new User(userId, userName, followers, null, null);

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
  

    @Test
    @DisplayName("T-001 Follow user service test")
    public void followUserGoodTest() {
        // Arrange
        Integer userId = 101;
        Integer userIdToFollow = 102;

        //construct the user to return
        UserFollowerDTO userFollowerDTO = new UserFollowerDTO(userId, "Alice Johnson", List.of(new FollowerDTO(userIdToFollow, "Bob Smith")));

        //construct the user received from the repository
        List<User> usersFollowed = List.of(new User(102, "Bob Smith", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        User user = new User(101, "Alice Johnson", new ArrayList<>(), usersFollowed, new ArrayList<>());

        // Act
        Mockito.when(userRepository.getFollowedUsers(userId, userIdToFollow)).thenReturn(Optional.of(user));
        var expected = userService.follow(userId, userIdToFollow);

        // Assert
        Assertions.assertEquals(expected, userFollowerDTO);

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

   
    private void validateAlphabeticalOrderTest(int userId, String order, boolean isAscendingOrder) {

        //arrange
        UserFollowerDTO expected = isAscendingOrder ? USER1DTO : USER1FOLLOWERSREVERSEDTO;

        FOLLOWERS.add(new User(102, "Bob Smith", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        FOLLOWERS.add(new User(103, "Charlie Brown", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        FOLLOWED.add(new User(104, "David Williams", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        FOLLOWED.add(new User(105, "Eva Martinez", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        //act
        Mockito.when(userRepository.getFollowers(userId)).thenReturn(USER1);

        if (isValidateExceptionTest) {
            //assert
            Assertions.assertThrows(
                    BadRequestException.class,
                    () -> userService.getUserWithFollowers(userId, order)
            );
        }
        else {
            //act
            UserFollowerDTO result = userService.getUserWithFollowers(userId, order);

            //assert
            Assertions.assertEquals(expected, result, "The value of the 'order' parameter is incorrect");
        }
    }

    @Test
    @DisplayName("Test that validates the value of the alphabetical order parameter for a value null")
    public void validateAlphabeticalOrderExceptionNullParameterTest(){
        //arrange
        isValidateExceptionTest = true;
        validateAlphabeticalOrderTest(101, null, true);
    }
    @Test
    @DisplayName("Test that validates the value of the alphabetical order parameter for a value empty")
    public void validateAlphabeticalOrderExceptionEmptyParameterTest(){
        //arrange
        isValidateExceptionTest = true;
        validateAlphabeticalOrderTest(101, " ", true);
    }
    @Test
    @DisplayName("Test that validates the value of the alphabetical order parameter for a value other than 'name_asc' or 'name_desc'")
    public void validateAlphabeticalOrderExceptionBadParameterTest(){
        //arrange
        isValidateExceptionTest = true;
        validateAlphabeticalOrderTest(101, "mal", true);
    }
    @Test
    @DisplayName("Test that validates the correct functionality of alphabetical order ascending")
    public void getUserWithFollowersAscTest(){
        //arrange
        validateAlphabeticalOrderTest(101, "name_asc", true);
    }
    @Test
    @DisplayName("Test that validates the correct functionality of alphabetical order descending")
    public void getUserWithFollowersDescTest(){
        //arrange
        validateAlphabeticalOrderTest(101, "name_desc", false);
    }


}

