package org.be_java_hisp_w24_g05.controller;


import jakarta.validation.constraints.Min;
import jakarta.validation.Valid;
import org.be_java_hisp_w24_g05.dto.CountFollowersDto;
import org.be_java_hisp_w24_g05.dto.UserFollowedDto;
import org.be_java_hisp_w24_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private IUserService userService;
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> searchUserFollowers(@PathVariable @Min(value = 1, message = "UserId tiene que ser mayor a cero") Integer userId, @RequestParam(defaultValue = "")  String order){

        return new ResponseEntity<>(userService.searchUserFollowers(userId,order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getSellerFollowedByUser(@PathVariable @Min(value = 1, message = "UserId tiene que ser mayor a cero") Integer userId, @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity<>(userService.getSellerFollowedByUser(userId, order), HttpStatus.OK);

    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowedDto> followUser(@PathVariable @Min(value = 1, message = "UserId tiene que ser mayor a cero")  Integer userId, @PathVariable int userIdToFollow){

        UserFollowedDto user = this.userService.followUser(userId, userIdToFollow);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserFollowedDto> unfollowUser(@PathVariable @Min(value = 1, message = "UserId tiene que ser mayor a cero") Integer userId, @PathVariable int userIdToUnfollow){

        UserFollowedDto user = this.userService.unfollowUser(userId, userIdToUnfollow);

        return ResponseEntity.ok(user);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDto> searchUserFollowers(@PathVariable @Min(value = 1, message = "UserId tiene que ser mayor a cero") Integer userId) {
        return ResponseEntity.ok(userService.searchUserFollowers(userId));
    }
}
