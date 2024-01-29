package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.UserFollowedDTO;
import com.socialmeli.SocialMeli.dto.UserFollowerDTO;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.service.interfaces.IUserService;
import com.socialmeli.SocialMeli.service.implementations.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    IUserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    ///GET users/{userId}/followers/count
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    //Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    // POST /users/{userId}/unfollow/{userIdToUnfollow}
    //Bodyless POST
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        if(userService.unfollow(userId, userIdToUnfollow)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> getFollowersOfUser(@PathVariable Integer userId,
                                                              @RequestParam(required = false, defaultValue = "name_asc") String order) {
        if(userId == null)
            throw new IllegalArgumentException("User Id is invalid");
        return ResponseEntity.ok(userService.getUserWithFollowers(userId, order));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowerDTO> followUser(@PathVariable Integer  userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);

    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable int userId,
                                                       @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.ok().body(this.userService.getFollowed(userId, order));
    }
}
