package org.socialmeli.be_java_hisp_w24_g04.unittest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowedDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowersDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.repository.UserRepository;
import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;
import org.socialmeli.be_java_hisp_w24_g04.service.UserService;
import java.util.Set;

import java.util.*;

import java.util.stream.Collectors;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    UserDTO userDTO1 = new UserDTO(1,"user1");
    UserDTO userDTO2 = new UserDTO(2,"user2");
    UserDTO userDTO3 = new UserDTO(3,"user3");
    Set<UserDTO> list = List.of(userDTO1,userDTO3, userDTO2).stream().collect(Collectors.toSet());

    @Test
    @DisplayName("Order by name asc test")
    public void orderByNameAscTest() {
        Assertions.assertDoesNotThrow(() -> IUserService.orderList("name_asc", list), "Order by name asc should not throw an exception");
    }

    @Test
    @DisplayName("Order by name desc test")
    public void orderByNameDescTest() {
        Assertions.assertDoesNotThrow(() -> IUserService.orderList("name_desc", list), "Order by name desc should not throw an exception");
    }

    @Test
    @DisplayName("Order by name invalid param test")
    public void orderByNameInvalidParamTest() {
        Assertions.assertThrows(BadRequestException.class, () -> IUserService.orderList("nameAsc", list), "Order by this param should throw an exception");
        Assertions.assertThrows(BadRequestException.class, () -> IUserService.orderList("id_asc", list), "Order by this param should throw an exception");
        Assertions.assertThrows(BadRequestException.class, () -> IUserService.orderList("name_a", list), "Order by this param should throw an exception");
    }

    @Test
    public void testRightOrderLists() {
        Set<UserDTO> ascList = List.of(userDTO1,userDTO2,userDTO3).stream().collect(Collectors.toSet());
        Set<UserDTO> descList = List.of(userDTO3,userDTO2,userDTO1).stream().collect(Collectors.toSet());

        Assertions.assertEquals(ascList, IUserService.orderList("name_asc", list));
        Assertions.assertEquals(descList, IUserService.orderList("name_desc", list));
    }

    @Test
    public void testWrongOrderLists() throws BadRequestException {
        Set<UserDTO> list = List.of(new UserDTO(1,"user1")).stream().collect(Collectors.toSet());

        Assertions.assertThrows(BadRequestException.class, () -> IUserService.orderList("name_asc_algo", list));
        Assertions.assertThrows(BadRequestException.class, () -> IUserService.orderList("id_asc", list));
        Assertions.assertThrows(BadRequestException.class, () -> IUserService.orderList("name_ascendent", list));
    }

    @Test
    public void testUserFollowedDTO() {
        Set<UserDTO> ascList = List.of(userDTO1,userDTO2,userDTO3).stream().collect(Collectors.toSet());
        Set<UserDTO> descList = List.of(userDTO3,userDTO2,userDTO1).stream().collect(Collectors.toSet());
        UserFollowedDTO dto = new UserFollowedDTO(4, "user 4", list);
        UserFollowedDTO expectedAsc = new UserFollowedDTO(4, "user 4", ascList);
        UserFollowedDTO expectedDesc = new UserFollowedDTO(4, "user 4", descList);

        Assertions.assertEquals(expectedAsc, dto.orderBy("name_asc"));
        Assertions.assertEquals(expectedDesc, dto.orderBy("name_asc"));
    }

    @Test
    public void testUserFollowersDTO() {
        Set<UserDTO> ascList = List.of(userDTO1,userDTO2,userDTO3).stream().collect(Collectors.toSet());
        Set<UserDTO> descList = List.of(userDTO3,userDTO2,userDTO1).stream().collect(Collectors.toSet());
        UserFollowersDTO dto = new UserFollowersDTO(4, "user 4", list);
        UserFollowersDTO expectedAsc = new UserFollowersDTO(4, "user 4", ascList);
        UserFollowersDTO expectedDesc = new UserFollowersDTO(4, "user 4", descList);

        Assertions.assertEquals(expectedAsc, dto.orderBy("name_asc"));
        Assertions.assertEquals(expectedDesc, dto.orderBy("name_desc"));
    }

    @Test
    @DisplayName("User Service: Verify if an existing user returns ok.")
    void testIfUserExists() {
        // Arrange
        Integer idParam = 1;
        User expectedUser = new User(
                idParam,
                "user1",
                new HashSet<>(){
                    {
                        add(userDTO1);
                        add(userDTO2);
                    }
                },
                new HashSet<>(){
                    {
                        add(userDTO3);
                    }
                }
        );

        // Act
        Mockito
                .when(userRepository.get(idParam))
                .thenReturn(Optional.of(expectedUser));

        var result = userService.findById(idParam);

        // Assert
        Assertions.assertEquals(expectedUser.getUsername(), result.getUsername());
        Assertions.assertEquals(expectedUser.getFollowers().size(), result.getFollowers().size());
    }

    @Test
    @DisplayName("User Service: Verify if an non-existing user throws error.")
    void testIfUserNotExists() {
        // Arrange
        int idParam = 2;

        // Act
        Mockito
                .when(userRepository.get(idParam))
                .thenReturn(Optional.empty());

        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.findById(idParam));
    }

    @Test
    public void testGetFollowersCount() {
        // arrange
        Set<UserDTO> followers = Set.of(
                new UserDTO(2, "user2"),
                new UserDTO(3, "user3"),
                new UserDTO(4, "user4")
        );

        User user = new User();
        user.setUserId(1);
        user.setFollowers(followers);

        Mockito.when(userRepository.get(user.getUserId())).thenReturn(Optional.of(user));

        // act
        Integer followersCount = userService.getFollowersCount(user.getUserId());

        // assert
        Assertions.assertEquals(3, followersCount);
    }

    @Test
    public void testGetFollowersCountInvalidUser() {
        // arrange
        Integer userId = 1;
        Mockito.when(userRepository.get(userId)).thenReturn(Optional.empty());

        // act & assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.getFollowersCount(userId));
    }

    @Test
    public void testFollow() {
        // arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;

        User user = new User();
        user.setUserId(userId);

        User userToFollow = new User();
        userToFollow.setUserId(userIdToFollow);

        Mockito.when(userRepository.get(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.get(userIdToFollow)).thenReturn(Optional.of(userToFollow));
        Mockito.when(userRepository.addFollower(user, userToFollow)).thenReturn(true);

        // act
        boolean followed = userService.follow(userId, userIdToFollow);

        // assert
        Assertions.assertTrue(followed);
    }

    @Test
    public void testFollowInvalidUser() {
        // arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;

        Mockito.when(userRepository.get(userId)).thenReturn(Optional.empty());

        // act & assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.follow(userId, userIdToFollow));
    }

    @Test
    public void testFollowInvalidTargetUser() {
        // arrange
        Integer userId = 1;
        User user = new User();
        user.setUserId(userId);

        Integer userIdToFollow = 2;

        Mockito.when(userRepository.get(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.get(userIdToFollow)).thenReturn(Optional.empty());

        // act & assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.follow(userId, userIdToFollow));
    }

    @Test
    public void testUnfollow() {
        // arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        User user = new User();
        user.setUserId(userId);

        User userToUnfollow = new User();
        userToUnfollow.setUserId(userIdToUnfollow);

        Mockito.when(userRepository.get(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.get(userIdToUnfollow)).thenReturn(Optional.of(userToUnfollow));
        Mockito.when(userRepository.removeFollower(user, userToUnfollow)).thenReturn(true);

        // act
        boolean unfollowed = userService.unfollow(userId, userIdToUnfollow);

        // assert
        Assertions.assertTrue(unfollowed);
    }

    @Test
    public void testUnfollowInvalidUser() {
        // arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        Mockito.when(userRepository.get(userId)).thenReturn(Optional.empty());

        // act & assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.unfollow(userId, userIdToUnfollow));
    }

    @Test
    public void testUnfollowInvalidTargetUser() {
        // arrange
        Integer userId = 1;
        User user = new User();
        user.setUserId(userId);

        Integer userIdToUnfollow = 2;

        Mockito.when(userRepository.get(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.get(userIdToUnfollow)).thenReturn(Optional.empty());

        // act & assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.unfollow(userId, userIdToUnfollow));
    }
}
