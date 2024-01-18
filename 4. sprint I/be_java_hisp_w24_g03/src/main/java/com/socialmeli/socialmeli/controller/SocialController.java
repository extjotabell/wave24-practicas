package com.socialmeli.socialmeli.controller;

import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.dto.UserFollowerDto;
import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.services.UserService;
import org.springframework.web.bind.annotation.*;
import com.socialmeli.socialmeli.services.PostService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    private final UserService userService;
    private final PostService postService;

    public SocialController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostIdDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersDto> getTotalFollowers(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(userService.getTotalFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowerDto> getFollowers(@PathVariable("userId") Integer userId, @RequestParam(defaultValue = "default", value = "order",required = false) String order) {
        return new ResponseEntity<>(userService.getFollowers(userId,order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> follow(@PathVariable("userId") Integer userId,
                                              @PathVariable("userIdToFollow") Integer userIdToFollow) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollow(@PathVariable("userId") Integer userId,
                                                @PathVariable("userIdToUnfollow") Integer userIdToUnfollow){
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> getAllFollowed(@PathVariable("userId") Integer userId, @RequestParam(defaultValue = "default", value = "order",required = false) String order) {
        return new ResponseEntity<>(userService.listFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.save(postDto), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserFollowedPostsDto> getLastTwoWeeksFollowedPosts(@PathVariable("userId") Integer userId, @RequestParam(defaultValue = "date_desc", required = false) String order){
        List<UserDto> followedList = userService.listFollowed(userId,"name_asc").followed();

        return new ResponseEntity<>(postService.getLastTwoWeeksFollowedPosts(userId, followedList, order), HttpStatus.OK);
    }

}

