package com.mercadolibre.be_java_hisp_w24_g02.controller;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UpdateToRelationshipsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserRelationshipsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * This endpoint is for unfollow a user
     * @param userId the id of the user who wants to unfollow
     * @param userIdToUnfollow the id of the user to unfollow
     *
     * @return a message of success
     * */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        UpdateToRelationshipsDTO followUserDTO = new UpdateToRelationshipsDTO(userId, userIdToUnfollow);
        this.userService.unfollowUser(followUserDTO);
        return ResponseEntity.ok("Usuario se dejo de seguir exitosamente");
    }

    /**
     * This endpoint is for follow a user
     * @param userId the id of the user who wants to follow
     * @param userIdToFollow the id of the user to follow
     *
     * @return a message of success
     * */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        UpdateToRelationshipsDTO followUserDTO = new UpdateToRelationshipsDTO(userId, userIdToFollow);
        userService.followUser(followUserDTO);
        return ResponseEntity.ok("Usuario seguido exitosamente");
    }

    /**
     * This endpoint returns a list of followers of a user
     * @param userId the id of the user
     * @param order the order of the list (name_asc or name_desc)
     *
     * @return a UserRelationshipsDTO with a list of followers of a user
     * */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserRelationshipsDTO> getUserFollowers(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "none") String order) {
        UserRelationshipsDTO userRelationshipsDTO = userService.getUserFollowers(userId, order);
        return ResponseEntity.ok(userRelationshipsDTO);
    }


    /**
     * This endpoint returns a list of followed of a user
     * @param userId the id of the user
     * @param order the order of the list (name_asc or name_desc)
     *
     * @return a UserRelationshipsDTO with a list of followed of a user
     * */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserRelationshipsDTO> getUserFollowed(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "none") String order) {
        UserRelationshipsDTO userRelationshipsDTO = userService.getUserFollowed(userId, order);
        return ResponseEntity.ok(userRelationshipsDTO);
    }

    /**
     * This endpoint returns the number of followers of a user
     * @param userId the id of the user
     *
     * @return the number of followers of a user
     * */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO>getUserFollowersCount(@PathVariable Integer userId){
        UserFollowersCountDTO userFollowersCountDTO = userService.getUserFollowersCount(userId);
        return ResponseEntity.ok(userFollowersCountDTO);
    }
}
