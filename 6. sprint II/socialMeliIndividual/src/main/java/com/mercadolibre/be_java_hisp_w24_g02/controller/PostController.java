package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
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
    @GetMapping("followed/{userId}/list")
    public ResponseEntity<UserFollowedsPostsDTO> getUserFollowed(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "none") String order) throws BadRequestException {
        UserFollowedsPostsDTO userServiceUserFollowed = postService.getFollowedPost(userId, order);
        return ResponseEntity.ok(userServiceUserFollowed);
    }


    /**
     * Add new promo post
     * @param promoPostDTO
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostDTO> addNewPromoPost(@Valid @RequestBody PromoPostDTO promoPostDTO){
        this.postService.createPromoPost(promoPostDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     *  This method is used to get the promos count of a user
     * @param userId the id of the user
     * @return a list of promos count
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromosCount(@RequestParam Integer userId){
        PromoPostCountDTO promoPostCountDTO = postService.getPromosCount(userId);
        return ResponseEntity.status(HttpStatus.OK).body(promoPostCountDTO);
    }

    /**
     * This method is used to add a post to favorites
     * @param userId the id of the user
     * @param postId the id of the post
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("/favorites/{userId}/{postId}")
    public ResponseEntity<?> addPostToFavorites(@PathVariable Integer userId, @PathVariable Integer postId){
        this.postService.addPostToFavorites(userId, postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * This method is used to remove a post to favorites
     * @param userId the id of the user
     * @param postId the id of the post
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @DeleteMapping("/favorites/{userId}/{postId}")
    public ResponseEntity<?> removePostToFavorites(@PathVariable Integer userId, @PathVariable Integer postId){
        this.postService.removePostToFavorites(userId, postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /**
     * This method is used to get the favorites of a user
     * @param userId the id of the user
     * @param postId the id of the post
     * @return a list of favorites
     */
    @GetMapping("/favorites/{userId}/list")
    public ResponseEntity<?> getUserFavorites(@PathVariable Integer userId, @PathVariable Integer postId){
        this.postService.getUserFavorites(userId, postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
