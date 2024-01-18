package org.socialmeli.be_java_hisp_w24_g04.controller;

import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowerCountDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPromoPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IPostService postService;

    @Autowired
    public ProductController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> searchAllFollowedLastTwoWeeks(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(postService.searchAllFollowedLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<SingleResponseDTO> createUserPost(@RequestBody UserPostDTO userPost) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.createUserPost(userPost))
        );
    }

    @PostMapping("/promo-post")
    public ResponseEntity<SingleResponseDTO> createUserPromoPost(@RequestBody UserPromoPostDTO userPromoPost) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.createUserPromoPost(userPromoPost))
        );
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SingleResponseDTO> countUserPromoPosts(
            @RequestParam Integer user_id
    ) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.countUserPromoPost(user_id))
        );
    }

    @GetMapping("/promo-post/category/{category}/list")
    public ResponseEntity<?> findPromoPostCategory(
            @PathVariable Integer category,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(postService.findPromoPostCategory(category, order), HttpStatus.OK);
    }
}