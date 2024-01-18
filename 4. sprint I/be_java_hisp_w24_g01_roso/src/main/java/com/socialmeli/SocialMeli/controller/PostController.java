package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.*;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.service.interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO postDTO) {
        if (postDTO.user_id() <= 0 || postDTO.product().product_id() <= 0 || postDTO.category().category_id() <= 0) {
            throw new BadRequestException("Id's must be greater than 0");
        }
        return ResponseEntity.ok().body(postService.createPost(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastestPostDTO> listPostUser(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_desc") String order) {
        order = this.postService.checkOrder(order);
        LastestPostDTO post = postService.getLastestPost(userId, order);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ExceptionDTO> createPromoPost(@RequestBody PostPromoRequestDTO postDTO) {
        if (postDTO.user_id() <= 0 || postDTO.product().product_id() <= 0 || postDTO.category() <= 0)
            throw new BadRequestException("Id's must be greater than 0");
        postService.createPromoPost(postDTO);
        return ResponseEntity.ok().body(new ExceptionDTO("Promo post created"));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ResponseQuantityPostPromoDTO> getQuantityPostsPromo(@RequestParam("user_id") Integer userId) {
        if (userId <= 0)
            throw new BadRequestException("Id's must be greater than 0");
        return ResponseEntity.ok().body(postService.getQuantityPostsPromo(userId));
    }

    @DeleteMapping("/post/{postId}/user/{userId}")
    public ResponseEntity<List<PostPromoRequestDTO>> deleteMyPostById(@PathVariable Integer postId, @PathVariable Integer userId) {
        if (userId <= 0)
            throw new BadRequestException("Id's must be greater than 0");
        return ResponseEntity.ok().body(postService.deleteMyPostById(userId, postId));
    }

    @GetMapping("/user/{userId}/posts/list/higher-price")
    public ResponseEntity<UserPostsByPriceResponseDTO> getMyPostsByHigherPrice(@PathVariable Integer userId) {
        if (userId <= 0)
            throw new BadRequestException("Id's must be greater than 0");
        return ResponseEntity.ok().body(postService.getMyPostsByHigherPrice(userId));
    }
}
