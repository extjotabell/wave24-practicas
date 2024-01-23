package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
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
     * US 0010
     * Method to add new promo-post
     *
     * @param promoPostDTO
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("/promo-post")
    public ResponseEntity<Post> addNewPromoPost(@Valid @RequestBody PromoPostDTO promoPostDTO){
        Post promoPostCountDTO = postService.createPromoPost(promoPostDTO);
        return ResponseEntity.status(HttpStatus.OK).body(promoPostCountDTO);
    }

    /**
     * US 0011
     * Method to get the promos count of a user
     *
     * @param userId the id of the user
     * @return a list of promos count
     */
    @GetMapping("/promo-post/count/{userId}")
    public ResponseEntity<PromoPostCountDTO> getPromosCount(@PathVariable Integer userId){
        PromoPostCountDTO promoPostCountDTO = postService.getPromosCount(userId);
        return ResponseEntity.status(HttpStatus.OK).body(promoPostCountDTO);
    }

    /**
     * US 0005
     * Method add new product post
     *
     * @param createPostDTO
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("/post")
    public ResponseEntity<?> addNewProductPost(@Valid @RequestBody CreatePostDTO createPostDTO){
        this.postService.createProductPost(createPostDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Method is used to get the followed posts of a user
     * @param userId the id of the user
     * @param order the order of the posts
     * @return a list of posts
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedsPostsDTO> getUserFollowed(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "none") String order) throws BadRequestException {
        UserFollowedsPostsDTO userServiceUserFollowed = postService.getFollowedPost(userId, order);
        return ResponseEntity.ok(userServiceUserFollowed);
    }

}
