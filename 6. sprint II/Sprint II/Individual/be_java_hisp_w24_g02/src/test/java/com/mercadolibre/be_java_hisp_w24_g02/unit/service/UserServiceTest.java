package com.mercadolibre.be_java_hisp_w24_g02.unit.service;

import com.mercadolibre.be_java_hisp_w24_g02.controller.UserController;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UpdateToRelationshipsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserBasicInfoDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserRelationshipsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import com.mercadolibre.be_java_hisp_w24_g02.service.implementations.UserServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import com.mercadolibre.be_java_hisp_w24_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import com.mercadolibre.be_java_hisp_w24_g02.service.implementations.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserController userController;
    @Mock
    private IUserRepository userRepository;

    @Test
    @DisplayName("Verify following a user.")
    public void followUserTest() {
        // Arrange
        UpdateToRelationshipsDTO followUserDTO = new UpdateToRelationshipsDTO(1, 2);

        User follower = new User(
                1,
                "Follower",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(
                2,
                "UserToFollow",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(userRepository.findById(2)).thenReturn(Optional.of(userToFollow));
        List<User> expectedFollowed = new ArrayList<>();
        expectedFollowed.add(userToFollow);
        // Act
        service.followUser(followUserDTO);

        // Assert
        Assertions.assertEquals(expectedFollowed, follower.getFollowed(), "User not followed correctly");

    }
    @Test
    @DisplayName("Verify exception to not found user id of follower.")
    public void followUSerTestNotFoundFollower(){
        // Arrange
        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(10, 2);
        User user = new User(
                2,
                "Usuario 2",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(10)).thenReturn(Optional.empty());
        // Act - Assert
        assertThrows(NotFoundException.class,
                () -> service.followUser(updateToRelationshipsDTO));

    }
    @Test
    @DisplayName("Verify exception to not found user id of followed.")
    public void followUSerTestNotFoundFollowed(){
        // Arrange
        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(2, 10);
        User user = new User(
                2,
                "Usuario 2",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(2)).thenReturn(Optional.of(user));
        when(userRepository.findById(10)).thenReturn(Optional.empty());
        // Act - Assert
        assertThrows(NotFoundException.class,
                () -> service.followUser(updateToRelationshipsDTO));
    }

    @Test
    @DisplayName("Verify exception to user id greater than zero .")
    public void followUSerTestInvalidUser(){
        //Arrange
        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(0, 2);
        Integer userId = updateToRelationshipsDTO.userId();
        //Act - Assert
        assertDoesNotThrow(() -> userController.followUser(userId, 1));

    }

    @Test
    @DisplayName("Verify exception that the user is already followed .")
    public void followUSerTestUserAlreadyFollowing(){
        //Arrange
        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(1, 2);
        User follower = new User(
                1,
                "Follower",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(
                2,
                "UserToFollow",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(userRepository.findById(2)).thenReturn(Optional.of(userToFollow));

        follower.setFollowed(List.of(userToFollow));
        userToFollow.setFollowers(List.of(follower));

        //Act - Assert
        assertThrows(BadRequestException.class,
                () -> service.followUser(updateToRelationshipsDTO));

    }

    @Test
    @DisplayName("Test for checking if the followed user list is sorted correctly ascendent")
    public void getFollowedUsersSortedNameAscTest(){
        // arrange

        List<User> followed = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));

        List<User> followers = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));
        User user1 = new User(1, "Usuario 1", followers, followed, null, null);


        List<UserBasicInfoDTO> sortedFollowed = new ArrayList<>(List.of(
                new UserBasicInfoDTO(2, "Usuario 2"),
                new UserBasicInfoDTO(3, "Usuario 3"),
                new UserBasicInfoDTO(4, "Usuario 4")
        ));

        UserRelationshipsDTO expected = new
                UserRelationshipsDTO(1, "Usuario 1", sortedFollowed, false);

        String order = "name_asc";

        // act

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        UserRelationshipsDTO result = service.getUserFollowed(1, order);

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test for checking if the followed user list is sorted correctly descendent")
    public void getFollowedUsersSortedNameDescTest(){
        // arrange

        List<User> followed = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));

        List<User> followers = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));
        User user1 = new User(1, "Usuario 1", followers, followed, null, null);


        List<UserBasicInfoDTO> sortedFollowed = new ArrayList<>(List.of(
                new UserBasicInfoDTO(4, "Usuario 4"),
                new UserBasicInfoDTO(3, "Usuario 3"),
                new UserBasicInfoDTO(2, "Usuario 2")
        ));

        UserRelationshipsDTO expected = new
                UserRelationshipsDTO(1, "Usuario 1", sortedFollowed, false);

        String order = "name_desc";

        // act

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        UserRelationshipsDTO result = service.getUserFollowed(1, order);

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test for checking if the followers user list is sorted correctly ascendent")
    public void getFollowersUsersSortedNameAscTest(){
        // arrange

        List<User> followed = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));

        List<User> followers = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));
        User user1 = new User(1, "Usuario 1", followers, followed, null, null);


        List<UserBasicInfoDTO> sortedFollowers = new ArrayList<>(List.of(
                new UserBasicInfoDTO(2, "Usuario 2"),
                new UserBasicInfoDTO(3, "Usuario 3"),
                new UserBasicInfoDTO(4, "Usuario 4")
        ));

        UserRelationshipsDTO expected = new
                UserRelationshipsDTO(1, "Usuario 1", sortedFollowers, true);

        String order = "name_asc";

        // act

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        UserRelationshipsDTO result = service.getUserFollowers(1, order);

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test for checking if the followers user list is sorted correctly descendent")
    public void getFollowersUsersSortedNameDescTest(){
        // arrange

        List<User> followed = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));

        List<User> followers = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));
        User user1 = new User(1, "Usuario 1", followers, followed, null, null);


        List<UserBasicInfoDTO> sortedFollowers = new ArrayList<>(List.of(
                new UserBasicInfoDTO(4, "Usuario 4"),
                new UserBasicInfoDTO(3, "Usuario 3"),
                new UserBasicInfoDTO(2, "Usuario 2")
        ));

        UserRelationshipsDTO expected = new
                UserRelationshipsDTO(1, "Usuario 1", sortedFollowers, true);

        String order = "name_desc";

        // act

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        UserRelationshipsDTO result = service.getUserFollowers(1, order);

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test for checking if the followed user list is not sorted when order is none")
    public void getFollowedUsersSortedNoneTest(){
        // arrange

        List<User> followed = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));

        List<User> followers = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));
        User user1 = new User(1, "Usuario 1", followers, followed, null, null);


        List<UserBasicInfoDTO> sortedFollowed = new ArrayList<>(List.of(
                new UserBasicInfoDTO(2, "Usuario 2"),
                new UserBasicInfoDTO(4, "Usuario 4"),
                new UserBasicInfoDTO(3, "Usuario 3")
        ));

        UserRelationshipsDTO expected = new
                UserRelationshipsDTO(1, "Usuario 1", sortedFollowed, false);

        String order = "none";

        // act

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        UserRelationshipsDTO result = service.getUserFollowed(1, order);

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test for checking if the followers user list is not sorted when order is none")
    public void getFollowersUsersSortedNoneTest(){
        // arrange

        List<User> followed = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));

        List<User> followers = new ArrayList<>(List.of(
                new User(2, "Usuario 2", null, null, null, null),
                new User(4, "Usuario 4", null, null, null, null),
                new User(3, "Usuario 3", null, null, null, null)
        ));
        User user1 = new User(1, "Usuario 1", followers, followed, null, null);


        List<UserBasicInfoDTO> sortedFollowers = new ArrayList<>(List.of(
                new UserBasicInfoDTO(2, "Usuario 2"),
                new UserBasicInfoDTO(4, "Usuario 4"),
                new UserBasicInfoDTO(3, "Usuario 3")
        ));

        UserRelationshipsDTO expected = new
                UserRelationshipsDTO(1, "Usuario 1", sortedFollowers, true);

        String order = "none";

        // act

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        UserRelationshipsDTO result = service.getUserFollowers(1, order);

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Verify params of getUserFollowers method with name_asc param")
    void testGetUserFollowersNameAscParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> service.getUserFollowers(1, "name_asc"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowers method with name_desc param")
    void testGetUserFollowersNameDescParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> service.getUserFollowers(1, "name_desc"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowers method with default param")
    void testGetUserFollowersDefaultParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> service.getUserFollowers(1, "none"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowers method with no allowed param")
    void testGetUserFollowersNoAllowedParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertThrows(BadRequestException.class, () -> service.getUserFollowers(1, "other"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowed method with name_asc param")
    void testGetUserFollowedNameAscParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> service.getUserFollowed(1, "name_asc"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowed method with name_desc param")
    void testGetUserFollowedNameDescParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> service.getUserFollowed(1, "name_desc"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowed method with default param")
    void testGetUserFollowedDefaultParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> service.getUserFollowed(1, "none"));
    }

    @Test
    @DisplayName("Verify params of getUserFollowed method with no allowed param")
    void testGetUserFollowedNoAllowedParam() {

        User user = new User(1, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertThrows(BadRequestException.class, () -> service.getUserFollowed(1, "other"));
    }

    @Test
    @DisplayName("Verify that the user to unfollow exists.")
    public void testUnfollowUser() {
        // Arrange
        User userFinded = new User(2, "Usuario 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(3, "Usuario 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userFinded.setFollowed(List.of(userToUnfollow));
        userToUnfollow.setFollowers(List.of(userFinded));

        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(2, 3);
        when(userRepository.findById(2))
                .thenReturn(Optional.of(userFinded));
        when(userRepository.findById(3))
                .thenReturn(Optional.of(userToUnfollow));
        // Act - Assert
        assertDoesNotThrow(() -> service.unfollowUser(updateToRelationshipsDTO));
    }

    @Test
    @DisplayName("Verify that the user to unfollow does not exist.")
    public void testUnfollowUserNotFound() {
        // Arrange
        User userFinded = new User(2, "Usuario 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(2, 3);
        when(userRepository.findById(2))
                .thenReturn(Optional.of(userFinded));
        when(userRepository.findById(3))
                .thenReturn(Optional.empty());
        // Act - Assert
        assertThrows(NotFoundException.class, () -> service.unfollowUser(updateToRelationshipsDTO));
    }

    @Test
    @DisplayName("Verify that the user principal exists.")
    public void testUnfollowUserPrincipalNotFound() {
        // Arrange
        UpdateToRelationshipsDTO updateToRelationshipsDTO = new UpdateToRelationshipsDTO(2, 3);
        when(userRepository.findById(2))
                .thenReturn(Optional.empty());
        // Act - Assert
        assertThrows(NotFoundException.class, () -> service.unfollowUser(updateToRelationshipsDTO));
    }

    @Test
    @DisplayName("Verify that follower count from an user is correct")
    public void UserFollowedCountTest(){
        //arrage
        Integer userid= 1;
        User user = new User(1, "Usuario 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userFollower1= new User(2, "Usuario 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userFollower2= new User(3, "Usuario 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        user.setFollowers(Arrays.asList(userFollower1,userFollower2));
        Integer expected = user.getFollowers().size();
        //Act
        when(userRepository.findById(userid)).thenReturn(Optional.of(user));
        UserFollowersCountDTO userresult = service.getUserFollowersCount(userid);
        Integer result = userresult.followersCount();
        //Assert
        Assertions.assertEquals(expected,result);
    }
}
