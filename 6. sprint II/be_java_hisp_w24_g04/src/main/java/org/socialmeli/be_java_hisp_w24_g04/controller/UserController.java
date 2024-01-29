package org.socialmeli.be_java_hisp_w24_g04.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SingleResponseDTO> getFollowers(
            @PathVariable
            @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
            @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
            Integer userId,
            @RequestParam(required = false) String order) {
        User user = userService.findById(userId);
        Set<UserDTO> followers = userService.getFollowers(userId);
        UserFollowersDTO dto = new UserFollowersDTO(user.getUserId(), user.getUsername(), followers);
        return ResponseEntity.ok(new SingleResponseDTO(200, (order == null) ? dto : dto.orderBy(order)));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<SingleResponseDTO> userFollowedList(
            @PathVariable
            @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
            @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
            Integer userId,

            @RequestParam(required = false) String order) {
        User user = userService.findById(userId);
        Set<UserDTO> followed = userService.getFollowed(userId);
        UserFollowedDTO dto = new UserFollowedDTO(user.getUserId(), user.getUsername(), followed);
        return ResponseEntity.ok(new SingleResponseDTO(200, (order == null) ? user : dto.orderBy(order)));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SingleResponseDTO> getFollowersCount(
            @PathVariable
            @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
            @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
            Integer userId
    ) {
        User user = userService.findById(userId);
        Integer followersCount = userService.getFollowersCount(userId);
        UserFollowerCountDTO response = new UserFollowerCountDTO(user.getUserId(), user.getUsername(), followersCount);
        return ResponseEntity.ok(new SingleResponseDTO(200, response));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(
            @PathVariable
            @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
            @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
            int userId,

            @PathVariable
            @NotNull(message = "Parámetro userIdToFollow faltante (tipo Integer).")
            @PositiveOrZero(message = "El userIdToFollow debe ser mayor a cero.")
            int userIdToFollow
    ) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(
            @PathVariable
            @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
            @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
            int userId,

            @PathVariable
            @NotNull(message = "Parámetro userIdToUnfollow faltante (tipo Integer).")
            @PositiveOrZero(message = "El userIdToUnfollow debe ser mayor a cero.")
            int userIdToUnfollow
    ) {
        userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }
}
