package org.socialmeli.be_java_hisp_w24_g04.controller;

import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
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

    @PostMapping({"/post", "/promo-post"})
    public ResponseEntity<SingleResponseDTO> createUserPost(@RequestBody UserPostDTO userPost) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.createUserPost(userPost))
        );
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SingleResponseDTO> getPromoPostsCount(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.getPromoPostsCount(userId))
        );
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SingleResponseDTO> getPromoPostsCount(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.getPromoPostsCount(userId))
        );
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<SingleResponseDTO> updatePost(
            @PathVariable Integer postId,
            @RequestBody UserPostDTO newPost
    ) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.updatePost(postId, newPost))
        );
    }
}
