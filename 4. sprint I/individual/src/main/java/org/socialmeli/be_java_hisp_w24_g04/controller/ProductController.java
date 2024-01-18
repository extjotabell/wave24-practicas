package org.socialmeli.be_java_hisp_w24_g04.controller;

import org.socialmeli.be_java_hisp_w24_g04.dto.*;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.service.IPostService;
import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IPostService postService;
    private final IUserService userService;

    @Autowired
    public ProductController(IPostService postService, IUserService userService) {
        this.postService = postService;
        this.userService = userService;
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
    public ResponseEntity<SingleResponseDTO> promoPost(@RequestBody ProductPostDTO post) {
        User user = this.userService.findById(post.user_id(), false);
        user.setPosts(this.postService.addDiscountPost(post));
        return ResponseEntity.ok(new SingleResponseDTO(200, user));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SingleResponseDTO> promoCount(@RequestParam int user_id) {
        User user = this.userService.findById(user_id, true);
        PromoPostCountDTO dto = new PromoPostCountDTO(user.getUserId(), user.getUsername(), this.postService.countDiscountProducts(user));
        return ResponseEntity.ok(new SingleResponseDTO(200, dto));
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<SingleResponseDTO> discountProductsBySeller(@RequestParam int user_id) {
        User user = userService.findById(user_id, true);
        UserPostsDTO dto = new UserPostsDTO(user.getUserId(), user.getUsername(), postService.getDiscountProducts(user));
        return ResponseEntity.ok(new SingleResponseDTO(200, dto));
    }
}
