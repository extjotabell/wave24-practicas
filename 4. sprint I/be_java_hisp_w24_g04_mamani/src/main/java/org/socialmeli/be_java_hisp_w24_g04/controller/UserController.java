package org.socialmeli.be_java_hisp_w24_g04.controller;

import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowedDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowerCountDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowersDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SingleResponseDTO> getFollowers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        UserFollowersDTO dto = userService.getFollowers(userId);
        return ResponseEntity.ok(new SingleResponseDTO(200, (order == null) ? dto : dto.order(order)));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<SingleResponseDTO> userFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) {
        UserFollowedDTO user = userService.getUserFollowedDTO(userService.findById(userId));
        return ResponseEntity.ok(new SingleResponseDTO(200, (order == null) ? user : user.orderBy(order)));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SingleResponseDTO> getFollowersCount(@PathVariable Integer userId) {
        User user = userService.findById(userId);
        UserFollowerCountDTO response = new UserFollowerCountDTO(user.getUserId(), user.getUsername(), user.getFollowers().size());
        return ResponseEntity.ok(new SingleResponseDTO(200, response));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable String userId, @PathVariable String userIdToFollow) {
        try {
            Integer userIdInt = Integer.parseInt(userId);
            Integer userIdToFollowInt = Integer.parseInt(userIdToFollow);
            userService.follow(userIdInt, userIdToFollowInt);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("User id and user id to follow must be integers");
        }
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable String userId, @PathVariable String userIdToUnfollow) {
        try {
            Integer userIdInt = Integer.parseInt(userId);
            Integer userIdToUnfollowInt = Integer.parseInt(userIdToUnfollow);
            userService.unfollow(userIdInt, userIdToUnfollowInt);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("User id and user id to unfollow must be integers");
        }
    }
}
