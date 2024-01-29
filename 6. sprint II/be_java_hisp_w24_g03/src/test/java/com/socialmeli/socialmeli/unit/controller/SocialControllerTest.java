package com.socialmeli.socialmeli.unit.controller;

import com.socialmeli.socialmeli.controller.SocialController;
import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.services.PostService;
import com.socialmeli.socialmeli.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SocialControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private PostService postService;

    @InjectMocks
    private SocialController socialController;

    @Test
    @DisplayName("getLastTwoWeeksFollowedPosts: should return a status code ok")
    public void getLastTwoWeeksFollowedPosts(){
        //Arrange
        Integer userId = 4698;
        String order = "name_asc";

        //Act
        List<UserDto> followedList = List.of(
                new UserDto(1465, "usuario1"),
                new UserDto(234, "usuario4"),
                new UserDto(123, "usuario5")
        );

        UserFollowedDto userFollowedList = new UserFollowedDto(
                4698,
                "usuario2",
                List.of(
                    new UserDto(1465, "usuario1"),
                    new UserDto(234, "usuario4"),
                    new UserDto(123, "usuario5")
        ));

        var expected = new UserFollowedPostsDto(123, List.of(new  PostDto(234,
                LocalDate.of(2024, 01, 16),
                new ProductDto(7, "Mochila", "", "Everlast", "Blue", "Permite Notebook"),
                100,
                8000.50)));

        Mockito.when(userService.listFollowed(userId, order)).thenReturn(userFollowedList);
        Mockito.when(postService.getLastTwoWeeksFollowedPosts(userId, followedList, order)).thenReturn(expected);
        var result = socialController.getLastTwoWeeksFollowedPosts(userId, order);

        //Assert
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

    }
}
