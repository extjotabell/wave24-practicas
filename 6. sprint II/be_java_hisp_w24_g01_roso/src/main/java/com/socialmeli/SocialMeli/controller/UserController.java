package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowedDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.UserFollowerDTO;
import com.socialmeli.SocialMeli.service.interfaces.IUserService;
import com.socialmeli.SocialMeli.service.implementations.UserService;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {


    IUserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    ///GET users/{userId}/followers/count
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable
                                                   @NotNull(message = "User id must not be empty")
                                                   @Min(value = 1, message = "User id must be greater than 0")  Integer userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    //Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    // POST /users/{userId}/unfollow/{userIdToUnfollow}
    //Bodyless POST
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable
                                          @NotNull(message = "User id must not be empty")
                                          @Min(value = 1, message = "User id must be greater than 0") Integer userId,
                                      @PathVariable
                                      @NotNull(message = "User id must not be empty")
                                      @Min(value = 1, message = "User id must be greater than 0") Integer userIdToUnfollow){

        return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> getFollowersOfUser(@PathVariable
                                                                  @NotNull(message = "User id must not be empty")
                                                                  @Min(value = 1, message = "User id must be greater than 0")Integer userId,
                                                              @RequestParam(required = false, defaultValue = "name_asc")
                                                              String order) {
        return ResponseEntity.ok(userService.getUserWithFollowers(userId, order));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowerDTO> followUser(@PathVariable
                                                          @NotNull(message = "User id must not be empty")
                                                          @Min(value = 1, message = "User id must be greater than 0")Integer  userId,
                                                      @PathVariable
                                                      @NotNull(message = "User id must not be empty")
                                                      @Min(value = 1, message = "User id must be greater than 0")Integer userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);

    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable
                                                           @NotNull(message = "User id must not be empty")
                                                           @Min(value = 1, message = "User id must be greater than 0")Integer userId,
                                                       @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.ok().body(this.userService.getFollowed(userId, order));
    }
}
