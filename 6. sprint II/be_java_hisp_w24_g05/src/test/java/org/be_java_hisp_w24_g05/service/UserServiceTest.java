package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.PostFollowedDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.CountFollowersDto;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.NotFoundException;
import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.UserDto;
import org.be_java_hisp_w24_g05.dto.UserFollowedByDto;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;

import org.be_java_hisp_w24_g05.dto.UserFollowersDto;

import org.be_java_hisp_w24_g05.exception.BadOrderException;

import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.UserFollowedDto;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private  Data data = new Data();
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("[T-0005] Verify exception in case of incorrect order")
    public void recentPostsOfFollowedUsersOrderIncorrect(){

        Assertions.assertThrows(BadRequestException.class, ()-> userService.recentPostsOfFollowedUsers(1,"patata"));
    }



    @Test
    @DisplayName("[T-0006] Verify correct order date_desc in case of null order")
    public void  recentPostsOfFollowedUsersNullOrder(){
        //arrange

        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));

        //act

        Mockito.when(userRepository.recentPostsOfFollowedUsers(1, "date_desc")).thenReturn(expectedPosts);

        PostFollowedDto expectedPostFollowedDto = new PostFollowedDto(1,expectedPosts);

        var result = userService.recentPostsOfFollowedUsers(1, "");

        //assert

        Assertions.assertEquals(expectedPostFollowedDto.getPosts(), result.getPosts());
    }

    @Test
    @DisplayName("[T-0003] Verify correct order")
    public void getSellerFollowedByUserTest(){

        // Arrange
        int userId = 1;
        String order = "";
        User user = data.loadData().get(0);
        List<UserFollowedByDto> expected = Collections.singletonList(new UserFollowedByDto(1, "User1",
                List.of(new UserDto(
                        2, "User2"
                ), new UserDto(
                        3, "User3"
                ))));

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        List<UserFollowedByDto> result = userService.getSellerFollowedByUser(userId, order);

        // Assert
        Assertions.assertEquals(expected, result, "The alphabetic order doesn't exists");

    }
    @Test
    @DisplayName("[T-0003] Verify correct order asc")
    public void getSellerFollowedByUserNameAscTest(){

        // Arrange
        int userId = 1;
        String order = "name_asc";
        User user = data.loadData().get(0);
        List<UserFollowedByDto> expected = Collections.singletonList(new UserFollowedByDto(1, "User1",
                List.of(new UserDto(
                        2, "User2"
                ), new UserDto(
                        3, "User3"
                ))));

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        List<UserFollowedByDto> result = userService.getSellerFollowedByUser(userId, order);

        // Assert
        Assertions.assertEquals(expected, result, "The alphabetic order doesn't exists");

    }

    @Test
    @DisplayName("[T-0003] Verify correct order desc")
    public void getSellerFollowedByUserNameDescTest(){

        // Arrange
        int userId = 1;
        String order = "name_desc";
        User user = data.loadData().get(0);
        List<UserFollowedByDto> expected = Collections.singletonList(new UserFollowedByDto(1, "User1",
                List.of(new UserDto(
                        3, "User3"
                ), new UserDto(
                        2, "User2"
                ))));

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        List<UserFollowedByDto> result = userService.getSellerFollowedByUser(userId, order);

        // Assert
        Assertions.assertEquals(expected, result, "The alphabetic order doesn't exists");

    }


    @Test
    @DisplayName("[T-0003] Verify name_asc and name_desc exist")
    public void getSellerFollowedByUserOrderTest(){

        // Arrange
        int userId = 1;
        String order = "name_des";
        User user = data.loadData().get(0);

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Assert
        Assertions.assertThrows(
                BadRequestException.class,
                ()->{
                    userService.getSellerFollowedByUser(userId, order);
                }
        ).printStackTrace();

    }


    @Test
   @DisplayName("[T-0003] Verify an exception thrown when order is different to name_asc or name_desc")
    public void searchUserFollowersExceptionTest(){

        // Arrange
        int userId = 1;
        String order = "name_des";
        User user = data.loadData().get(0);

        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Assert
        Assertions.assertThrows(
                BadOrderException.class,
                ()->{
                    userService.searchUserFollowers(userId, order);
                }
        );

    }

    @Test
    @DisplayName("[T-0003] [T-0004] Verify name_asc works as expected in searchUserFollowers")
    public void searchUserFollowersOrderByNameAscTest(){
        // Arrange
        int userId = 1;
        String order = "name_asc";
        User user = data.loadData().get(0);

        List<UserFollowersDto> expected = Collections.singletonList(
                                                        new UserFollowersDto(1,
                                                                            "User1",
                                                                            List.of(
                                                                                new UserDto(2, "User2"),
                                                                                new UserDto(3, "User3"),
                                                                                new UserDto(4, "User4"))));
        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Assert
        Assertions.assertEquals(expected, userService.searchUserFollowers(userId, order),"The order by name_asc is not working as expected");

    }
    @Test
    @DisplayName("[T-0003] [T-0004] Verify name_desc works as expected in searchUserFollowers")
    public void searchUserFollowersOrderByNameDescTest(){

        // Arrange
        int userId = 1;
        String order = "name_desc";
        User user = data.loadData().get(0);

        List<UserFollowersDto> expected = Collections.singletonList(
                new UserFollowersDto(1,
                        "User1",
                        List.of(
                                new UserDto(4, "User4"),
                                new UserDto(3, "User3"),
                                new UserDto(2, "User2"))));
        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Assert
        Assertions.assertEquals(expected, userService.searchUserFollowers(userId, order),"The order by name_desc is not working as expected");

    }


    @Test
    @DisplayName("[T-0003] [T-0004] Verify searchUserFollowers works as expected")
    public void searchUserFollowersTest(){

        // Arrange
        int userId = 1;
        String order = "";
        User user = data.loadData().get(0);

        List<UserFollowersDto> expected = Collections.singletonList(
                new UserFollowersDto(1,
                        "User1",
                        List.of(
                                new UserDto(2, "User2"),
                                new UserDto(3, "User3"),
                                new UserDto(4, "User4"))));
        // Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Assert
        Assertions.assertEquals(expected, userService.searchUserFollowers(userId, order),"The method searchUserFollowers is not working as expected");

    }
    @Test
    @DisplayName("[T-0007] - Verify that the number of followers of a certain user is correct. (US-0002) - User with id 1")
    public void searchUserFollowersId1() {

        CountFollowersDto expected = new CountFollowersDto(1, "User1", 3);

        User user = data.loadData().get(0);

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));

        CountFollowersDto result = userService.searchUserFollowers(1);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("[T-0007] - Verify that the number of followers of a certain user is correct. (US-0002) - User with id 2")
    public void searchUserFollowersId2() {

        CountFollowersDto expected = new CountFollowersDto(2, "User2", 0);

        User user = data.loadData().get(1);

        Mockito.when(userRepository.findById(2)).thenReturn(Optional.of(user));

        CountFollowersDto result = userService.searchUserFollowers(2);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("[T-0007] - Verify that the number of followers of a certain user is correct. (US-0002) - User with id 3")
    public void searchUserFollowersId3() {

        CountFollowersDto expected = new CountFollowersDto(3, "User3", 0);

        User user = data.loadData().get(2);

        Mockito.when(userRepository.findById(3)).thenReturn(Optional.of(user));

        CountFollowersDto result = userService.searchUserFollowers(3);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("[T-0007] - Verify that the number of followers of a certain user is correct. (US-0002) - User with id 4")
    public void searchUserFollowersId4() {

        CountFollowersDto expected = new CountFollowersDto(4, "User4", 1);

        User user = data.loadData().get(3);

        Mockito.when(userRepository.findById(4)).thenReturn(Optional.of(user));

        CountFollowersDto result = userService.searchUserFollowers(4);

        Assertions.assertEquals(expected, result);
    }
    @Test
    @DisplayName("[T-0007] - Verify that the number of followers of a certain user is correct. (US-0002) - User null")
    public void searchUserFollowersNotFound() {

        Mockito.when(userRepository.findById(10)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> userService.searchUserFollowers(10));
    }


    @Test
    @DisplayName("[T-0001] - Test of verify id user to follow exists")
    public void followUserTest() {

        UserFollowedDto expected = new UserFollowedDto(2, "User2", 1);

        User userExpected = new User(2, "User2", new ArrayList<>(), List.of(data.getUSER_3()), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.ofNullable(data.loadData().get(1)));
        when(userRepository.findById(2)).thenReturn(Optional.ofNullable(data.loadData().get(2)));
        when(userRepository.addFollower(data.loadData().get(1), data.loadData().get(2))).thenReturn(userExpected);


        UserFollowedDto result = userService.followUser(1, 2);

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("[T-0001] - Test of verify id user to follow don't exists")
    public void followUserNoExist(){
        when(userRepository.findById(1)).thenReturn(Optional.ofNullable(data.loadData().get(1)));
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        Assertions.assertThrows(BadRequestException.class, () -> {
            userService.followUser(1, 2);
        });
    }

    @Test
    @DisplayName("[T-0002] - Test of verify user to unfollow exists")
    public void unfollowUserTest() {

        UserFollowedDto expected = new UserFollowedDto(1, "User1", 1);

        User userExpected = new User(1, "User1", new ArrayList<>(), List.of(data.getUSER_3()), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.ofNullable(data.loadData().get(0)));
        when(userRepository.removeFollower(data.loadData().get(0), 2)).thenReturn(userExpected);

        UserFollowedDto result = userService.unfollowUser(1, 2);

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("[T-0002] -Test of verify user to unfollow don't exists")
    public void unfollowUserNoExist(){
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(BadRequestException.class, () -> {
            userService.unfollowUser(1, 2);
        });
    }




}
