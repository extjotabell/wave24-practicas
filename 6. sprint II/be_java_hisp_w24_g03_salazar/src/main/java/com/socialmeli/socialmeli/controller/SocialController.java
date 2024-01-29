package com.socialmeli.socialmeli.controller;

import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.dto.UserFollowerDto;
import com.socialmeli.socialmeli.dto.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.services.UserService;
import com.socialmeli.socialmeli.services.PostService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
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
    public ResponseEntity<UserFollowersDto> getTotalFollowers(@PathVariable("userId") @Min(value = 1, message= "El id debe ser mayor a 0") @NotNull Integer userId) {
        return new ResponseEntity<>(userService.getTotalFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowerDto> getFollowers(@PathVariable("userId") @Min(value = 1, message= "El id debe ser mayor a 0") @NotNull Integer userId, @RequestParam(defaultValue = "default", value = "order",required = false) String order) {
        return new ResponseEntity<>(userService.getFollowers(userId,order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> follow(@PathVariable("userId") @Min(value = 1, message= "El id debe ser mayor a 0") @NotNull Integer userId,
                                              @PathVariable("userIdToFollow") @Min(value = 1, message= "El idToFollow debe ser mayor a 0") @NotNull Integer userIdToFollow) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollow(@PathVariable("userId") @Min(value = 1, message= "El id debe ser mayor a 0") @NotNull Integer userId,
                                                @PathVariable("userIdToUnfollow") @Min(value = 1, message= "El idToUnfollow debe ser mayor a 0") @NotNull Integer userIdToUnfollow){
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> getAllFollowed(@PathVariable("userId") @Min(value = 1, message= "El id debe ser mayor a 0") @NotNull Integer userId, @RequestParam(defaultValue = "default", value = "order",required = false) String order) {
        return new ResponseEntity<>(userService.listFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<PostIdDto> createPost(@RequestBody @Valid PostDto postDto){
        return new ResponseEntity<>(postService.save(postDto), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserFollowedPostsDto> getLastTwoWeeksFollowedPosts(@PathVariable("userId") @Min(value = 1, message= "El id debe ser mayor a 0") @NotNull Integer userId, @RequestParam(defaultValue = "date_desc", required = false) String order){
        List<UserDto> followedList = userService.listFollowed(userId,"name_asc").followed();

        return new ResponseEntity<>(postService.getLastTwoWeeksFollowedPosts(userId, followedList, order), HttpStatus.OK);
    }

}

