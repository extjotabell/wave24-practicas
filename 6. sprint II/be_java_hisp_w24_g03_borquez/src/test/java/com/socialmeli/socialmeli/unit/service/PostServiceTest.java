package com.socialmeli.socialmeli.unit.service;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.exceptions.BadRequestException;
import com.socialmeli.socialmeli.dto.UserFollowedPostsDto;
import com.socialmeli.socialmeli.entities.Post;
import com.socialmeli.socialmeli.exceptions.NotFoundException;
import com.socialmeli.socialmeli.mapper.Mapper;
import com.socialmeli.socialmeli.repositories.PostRepositoryImpl;
import com.socialmeli.socialmeli.services.PostService;
import com.socialmeli.socialmeli.utils.PostUtils;
import com.socialmeli.socialmeli.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    Mapper mapper;

    @InjectMocks
    private PostService postService;

    PostUtils postUtils = new PostUtils();

    UserUtils userUtils = new UserUtils();

    // Constantes

    @Test
    @DisplayName("getLastTwoWeeksFollowedPosts: should return UserFollowedPostsDto")
    public void getLastTwoWeeksFollowedPosts(){
        //Arrange
        Integer userId = 4698;
        String order = "date_desc";
        List<UserDto> followedList = userUtils.getFollowedList();

        ArrayList<Post> allPosts = new ArrayList<>(Arrays.asList(postUtils.getPostId1(), postUtils.getPostId2(), postUtils.getPostId7()));

        List<PostDto> posts = List.of(postUtils.getPostDtoId7(), postUtils.getPostDtoId1(), postUtils.getPostDtoId2());

        UserFollowedPostsDto expected = new UserFollowedPostsDto(userId, posts);

        //Act
        Mockito.when(this.postRepository.findAll()).thenReturn(allPosts);
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId1())).thenReturn(postUtils.getPostDtoId1());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId2())).thenReturn(postUtils.getPostDtoId2());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId7())).thenReturn(postUtils.getPostDtoId7());
        var result = postService.getLastTwoWeeksFollowedPosts(userId, followedList, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("getLastTwoWeeksFollowedPosts: should return NotFoundException when followedList is empty")
    public void followedListEmptyGetLastTwoWeeksFollowedPosts(){
        //Arrange
        Integer userId = 234;
        String order = "date_desc";
        List<UserDto> followedList = new ArrayList<>();

        //Assert
        Assertions.assertThrows(NotFoundException.class, () ->{
            postService.getLastTwoWeeksFollowedPosts(userId, followedList, order);
        });
    }

    @Test
    @DisplayName("getLastTwoWeeksFollowedPosts: should return NotFoundException when allFollowedPosts is empty")
    public void allFollowedPostsEmptyGetLastTwoWeeksFollowedPosts(){
        //Arrange
        Integer userId = 567;
        String order = "date_desc";
        List<UserDto> followedList = new ArrayList<>();

        //Assert
        Assertions.assertThrows(NotFoundException.class, () ->{
            postService.getLastTwoWeeksFollowedPosts(userId, followedList, order);
        });
    }

    @Test
    @DisplayName("Verify that the order 'date_desc' exists")
    public void dateDescOrderHappyPath(){
        //Arrange
        Integer userId = 4698;
        String order = "date_desc";
        List<UserDto> followedList = userUtils.getFollowedList();

        ArrayList<Post> allPosts = new ArrayList<>(Arrays.asList(postUtils.getPostId1(), postUtils.getPostId2(), postUtils.getPostId7()));

        //Act
        Mockito.when(this.postRepository.findAll()).thenReturn(allPosts);
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId1())).thenReturn(postUtils.getPostDtoId1());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId2())).thenReturn(postUtils.getPostDtoId2());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId7())).thenReturn(postUtils.getPostDtoId7());

        // Act y Assert
        Assertions.assertDoesNotThrow(() -> postService.getLastTwoWeeksFollowedPosts(userId, followedList, order),
                "The order date_desc should exists");
    }

    @Test
    @DisplayName("Verify that the order 'date_desc' exists")
    public void dateAscOrderHappyPath(){
        //Arrange
        Integer userId = 4698;
        String order = "date_asc";
        List<UserDto> followedList = userUtils.getFollowedList();

        ArrayList<Post> allPosts = new ArrayList<>(Arrays.asList(postUtils.getPostId1(), postUtils.getPostId2(), postUtils.getPostId7()));

        //Act
        Mockito.when(this.postRepository.findAll()).thenReturn(allPosts);
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId1())).thenReturn(postUtils.getPostDtoId1());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId2())).thenReturn(postUtils.getPostDtoId2());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId7())).thenReturn(postUtils.getPostDtoId7());

        // Act y Assert
        Assertions.assertDoesNotThrow(() -> postService.getLastTwoWeeksFollowedPosts(userId, followedList, order),
                "The order date_desc should exists");
    }

    @Test
    @DisplayName("Verify that the order date is invalid by throwing an exception")
    public void dateOrderSadPath(){
        // Arrange
        //Arrange
        Integer userId = 4698;
        String order = "invalid_order";
        List<UserDto> followedList = userUtils.getFollowedList();

        ArrayList<Post> allPosts = new ArrayList<>(Arrays.asList(postUtils.getPostId1(), postUtils.getPostId2(), postUtils.getPostId7()));

        //Act
        Mockito.when(this.postRepository.findAll()).thenReturn(allPosts);
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId1())).thenReturn(postUtils.getPostDtoId1());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId2())).thenReturn(postUtils.getPostDtoId2());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId7())).thenReturn(postUtils.getPostDtoId7());

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> postService.getLastTwoWeeksFollowedPosts(userId, followedList, order));
    }

    @Test
    @DisplayName("Verify the correct order by date_desc")
    public void sortDescLastFollowedPostTest(){
        //Arrange
        Integer userId = 4698;
        String order = "date_desc";
        List<UserDto> followedList = userUtils.getFollowedList();

        ArrayList<Post> allPosts = new ArrayList<>(Arrays.asList(postUtils.getPostId1(), postUtils.getPostId2(), postUtils.getPostId7()));

        //Add to list descending
        List<PostDto> posts = List.of(postUtils.getPostDtoId7(), postUtils.getPostDtoId1(), postUtils.getPostDtoId2());

        UserFollowedPostsDto expected = new UserFollowedPostsDto(userId, posts);

        //Act
        Mockito.when(this.postRepository.findAll()).thenReturn(allPosts);
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId1())).thenReturn(postUtils.getPostDtoId1());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId2())).thenReturn(postUtils.getPostDtoId2());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId7())).thenReturn(postUtils.getPostDtoId7());
        var result = postService.getLastTwoWeeksFollowedPosts(userId, followedList, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Verify the correct order by date_asc")
    public void sortAscLastFollowedPostTest(){
        //Arrange
        Integer userId = 4698;
        String order = "date_asc";
        List<UserDto> followedList = userUtils.getFollowedList();

        ArrayList<Post> allPosts = new ArrayList<>(Arrays.asList(postUtils.getPostId1(), postUtils.getPostId2(), postUtils.getPostId7()));

        //Add to list ascending
        List<PostDto> posts = List.of(postUtils.getPostDtoId2(), postUtils.getPostDtoId1(), postUtils.getPostDtoId7());

        UserFollowedPostsDto expected = new UserFollowedPostsDto(userId, posts);

        //Act
        Mockito.when(this.postRepository.findAll()).thenReturn(allPosts);
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId1())).thenReturn(postUtils.getPostDtoId1());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId2())).thenReturn(postUtils.getPostDtoId2());
        Mockito.when(mapper.convertPostToDto(postUtils.getPostId7())).thenReturn(postUtils.getPostDtoId7());
        var result = postService.getLastTwoWeeksFollowedPosts(userId, followedList, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }
}
