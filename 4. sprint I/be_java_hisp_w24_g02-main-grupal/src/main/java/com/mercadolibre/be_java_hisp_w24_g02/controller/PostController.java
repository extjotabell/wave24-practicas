package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("products")
public class PostController {
    @Autowired
    private IPostService postService;

    /**
     * Add new product post
     * @param createPostDTO
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("/post")
    public ResponseEntity<?> addNewProductPost(@Valid @RequestBody CreatePostDTO createPostDTO){
        this.postService.createProductPost(createPostDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * This method is used to get the followed posts of a user
     * @param userId the id of the user
     * @param order the order of the posts
     * @return a list of posts
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedsPostsDTO> getUserFollowed(@PathVariable Integer userId, @RequestParam(defaultValue = "none") String order) throws BadRequestException {
        UserFollowedsPostsDTO userServiceUserFollowed = postService.getFollowedPost(userId, order);
        return ResponseEntity.ok(userServiceUserFollowed);
    }

}
